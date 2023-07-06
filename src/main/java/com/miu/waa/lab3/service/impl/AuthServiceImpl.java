package com.miu.waa.lab3.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.miu.waa.lab3.entity.Role;
import com.miu.waa.lab3.entity.User;
import com.miu.waa.lab3.entity.dto.AuthResponse;
import com.miu.waa.lab3.entity.dto.SigninRequest;
import com.miu.waa.lab3.entity.dto.SignupRequest;
import com.miu.waa.lab3.exception.Exceptions;
import com.miu.waa.lab3.repo.RoleRepo;
import com.miu.waa.lab3.repo.UserRepo;
import com.miu.waa.lab3.service.AuthService;
import com.miu.waa.lab3.util.JwtUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;
    private final ModelMapper modelMapper;
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public AuthResponse signin(SigninRequest signinRequest) {
        Authentication result = null;

        try {
            result = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(signinRequest.getEmail(), signinRequest.getPassword()));
        } catch (Exception e) {
            throw Exceptions.BAD_CREDENTIAL_EXCEPTION;
        }

        if (result == null) {
            throw Exceptions.BAD_CREDENTIAL_EXCEPTION;
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(result.getName());

        final String accessToken = jwtUtil.generateToken(userDetails);

        return new AuthResponse(accessToken);
    }

    @Override
    public void signup(SignupRequest signupRequest) {
        if (!signupRequest.getPassword().equals(signupRequest.getRetypePassword())) {
            throw Exceptions.INVALID_SIGNUP_PASSWORDS;
        }

        User user = modelMapper.map(signupRequest, User.class);
        Optional<Role> optionalRole = roleRepo.findByName("USER");

        if (!optionalRole.isPresent()) {
            throw Exceptions.ROLE_NOT_FOUND;
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        List<Role> roles = new ArrayList<>();
        roles.add(optionalRole.get());

        user.setRoles(roles);;
        userRepo.save(user);
    }
}

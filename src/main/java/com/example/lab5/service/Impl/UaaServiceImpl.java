package com.example.lab5.service.Impl;

import com.example.lab5.entity.Role;
import com.example.lab5.entity.User;
import com.example.lab5.entity.dto.requests.LoginRequest;
import com.example.lab5.entity.dto.requests.RefreshTokenRequest;
import com.example.lab5.entity.dto.requests.RegisterRequest;
import com.example.lab5.entity.dto.respnse.LoginResponse;
import com.example.lab5.repository.RoleRepo;
import com.example.lab5.repository.UserRepo;
import com.example.lab5.security.AwesomeUserDetails;
import com.example.lab5.service.UaaService;
import com.example.lab5.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UaaServiceImpl implements UaaService {

    private final RoleRepo roleRepo;

    private final UserRepo userRepo;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil = new JwtUtil();

    private final PasswordEncoder passwordEncoder;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        Authentication result;
        try {
            result = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUserName(),
                            loginRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            System.out.println("Bad Credentials");
            throw new BadCredentialsException(e.getMessage());
        }
        final String accessToken = generateAccessToken(result.getName());
        final String refreshToken = jwtUtil.generateRefreshToken(loginRequest.getUserName());
        return new LoginResponse(accessToken, refreshToken);
    }

    @Override
    public LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        boolean isRefreshTokenValid = jwtUtil.validateToken(refreshTokenRequest.getRefreshToken());
        if (isRefreshTokenValid) {
            var isAccessTokenExpired = jwtUtil.isTokenExpired(refreshTokenRequest.getAccessToken());
            if (isAccessTokenExpired)
                System.out.println("ACCESS TOKEN IS EXPIRED");
            else
                System.out.println("ACCESS TOKEN IS NOT EXPIRED");
            String userName = jwtUtil.doGenerateToken(jwtUtil.extractUsername(refreshTokenRequest.getRefreshToken()));
            final String accessToken = generateAccessToken(userName);
            return new LoginResponse(accessToken, refreshTokenRequest.getRefreshToken());
        }
        return new LoginResponse();
    }

    @Override
    public LoginResponse signUp(RegisterRequest request) {
        List<Role> roles = request.getRoles().stream().map(roleRepo::findByName).collect(Collectors.toList());
        var user = new User(
                request.getFirstName(),
                request.getLastName(),
                request.getUserName(),
                passwordEncoder.encode(request.getPassword()),
                roles);
        var savedUser = userRepo.save(user);
        System.out.println("User: " + user);
        UserDetails userDetails = new AwesomeUserDetails(user);
        var jwtToken = jwtUtil.generateToken(userDetails);
        final String refreshToken = jwtUtil.generateRefreshToken(user.getUserName());
        return new LoginResponse(jwtToken, refreshToken);
    }

    private String generateAccessToken(String userName) {
        final UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
        return jwtUtil.generateToken(userDetails);
    }
}

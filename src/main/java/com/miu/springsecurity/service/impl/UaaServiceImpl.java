package com.miu.springsecurity.service.impl;

import com.miu.springsecurity.entity.User;
import com.miu.springsecurity.entity.model.LoginRequest;
import com.miu.springsecurity.entity.model.LoginResponse;
import com.miu.springsecurity.entity.model.RefreshTokenRequest;
import com.miu.springsecurity.repository.RoleRepo;
import com.miu.springsecurity.repository.UserRepo;
import com.miu.springsecurity.security.JwtHelper;
import com.miu.springsecurity.service.UaaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UaaServiceImpl implements UaaService {
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private  final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final RoleRepo roleRepo;
    private final UserRepo userRepo;
    private final JwtHelper jwtHelper;
    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        try {
            var result = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                            loginRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            log.info("Bad Credentials");
        }

        final String accessToken = jwtHelper.generateToken(loginRequest.getEmail());
        final String refreshToken = jwtHelper.generateRefreshToken(loginRequest.getEmail());
        var loginResponse = new LoginResponse(accessToken, refreshToken);
        return loginResponse;
    }

    @Override
    public void register(User user) {

        var password=user.getPassword();
        user.setPassword(bCryptPasswordEncoder.encode(password));
        user.setRoles(roleRepo.findByRole("USER"));
        var response=userRepo.save(user);
    }

    @Override
    public LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        boolean isRefreshTokenValid = jwtHelper.validateToken(refreshTokenRequest.getRefreshToken());
        if (isRefreshTokenValid) {
            final String accessToken = jwtHelper.generateToken(jwtHelper.getSubject(refreshTokenRequest.getRefreshToken()));
            var loginResponse = new LoginResponse(accessToken, refreshTokenRequest.getRefreshToken());
            return loginResponse;
        }
        return new LoginResponse();
    }
}

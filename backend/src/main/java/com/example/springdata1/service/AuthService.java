package com.example.springdata1.service;

import com.example.springdata1.entity.dto.request.LoginRequest;
import com.example.springdata1.entity.dto.response.LoginResponse;
import com.example.springdata1.entity.dto.request.RefreshTokenRequest;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}

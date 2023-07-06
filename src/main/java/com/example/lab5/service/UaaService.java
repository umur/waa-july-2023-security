package com.example.lab5.service;

import com.example.lab5.entity.dto.requests.LoginRequest;
import com.example.lab5.entity.dto.requests.RefreshTokenRequest;
import com.example.lab5.entity.dto.requests.RegisterRequest;
import com.example.lab5.entity.dto.respnse.LoginResponse;

public interface UaaService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
    LoginResponse signUp(RegisterRequest registerRequest);
}

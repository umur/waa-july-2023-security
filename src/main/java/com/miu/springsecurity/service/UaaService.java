package com.miu.springsecurity.service;

import com.miu.springsecurity.entity.User;
import com.miu.springsecurity.entity.model.LoginRequest;
import com.miu.springsecurity.entity.model.LoginResponse;
import com.miu.springsecurity.entity.model.RefreshTokenRequest;

public interface UaaService {
    LoginResponse login(LoginRequest loginRequest);
    void register(User user);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}

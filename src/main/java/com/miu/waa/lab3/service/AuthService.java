package com.miu.waa.lab3.service;

import com.miu.waa.lab3.entity.dto.AuthResponse;
import com.miu.waa.lab3.entity.dto.SigninRequest;
import com.miu.waa.lab3.entity.dto.SignupRequest;

public interface AuthService {
    public AuthResponse signin(SigninRequest loginRequest);

    public void signup(SignupRequest registerRequest);
}

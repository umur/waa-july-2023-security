package com.miu.waa.lab3.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miu.waa.lab3.entity.dto.AuthResponse;
import com.miu.waa.lab3.entity.dto.SigninRequest;
import com.miu.waa.lab3.entity.dto.SignupRequest;
import com.miu.waa.lab3.service.impl.AuthServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/uaa")
@RequiredArgsConstructor
public class UaaController {
    private final AuthServiceImpl authServiceImpl;

    @PostMapping("/signin")
    public AuthResponse sigin(@RequestBody SigninRequest signinRequest) {
        return authServiceImpl.signin(signinRequest);
    }

    @PostMapping("/signup")
    public void signup(@RequestBody SignupRequest signupRequest) {
        authServiceImpl.signup(signupRequest);
    }
}

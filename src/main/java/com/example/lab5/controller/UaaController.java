package com.example.lab5.controller;

import com.example.lab5.entity.dto.requests.LoginRequest;
import com.example.lab5.entity.dto.requests.RefreshTokenRequest;
import com.example.lab5.entity.dto.requests.RegisterRequest;
import com.example.lab5.entity.dto.respnse.LoginResponse;
import com.example.lab5.service.UaaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/uaa")
@RequiredArgsConstructor
public class UaaController {

    private final UaaService authService;

    @PostMapping("/signIn")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        var loginResponse = authService.login(loginRequest);
        return new ResponseEntity<LoginResponse>(
                loginResponse, HttpStatus.OK);
    }

    @PostMapping("/refreshToken")
    public LoginResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return authService.refreshToken(refreshTokenRequest);
    }

    @PostMapping("/signUp")
    public LoginResponse signUp(@RequestBody RegisterRequest registerRequest) {
        System.out.println("RegisterRequest: " + registerRequest);
        return authService.signUp(registerRequest);
    }
}

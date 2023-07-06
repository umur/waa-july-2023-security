package com.miu.springsecurity.controller;

import com.miu.springsecurity.entity.User;
import com.miu.springsecurity.entity.model.LoginRequest;
import com.miu.springsecurity.entity.model.LoginResponse;
import com.miu.springsecurity.entity.model.RefreshTokenRequest;

import com.miu.springsecurity.service.UaaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/uaa")
//@RequiredArgsConstructor
public class UaaController {
    private final UaaService uaaService;



    public UaaController(UaaService uaaService) {
        this.uaaService = uaaService;

    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
    var loginResponse=uaaService.login(loginRequest);
    return ResponseEntity.ok().body(loginResponse);
    }

    @PostMapping("/refreshToken")
    public LoginResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return uaaService.refreshToken(refreshTokenRequest);
    }


    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody User user){
        uaaService.register(user);
        return ResponseEntity.ok().body("User Registered");


    }

}

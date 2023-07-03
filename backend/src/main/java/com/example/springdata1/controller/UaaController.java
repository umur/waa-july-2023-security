package com.example.springdata1.controller;

import com.example.springdata1.entity.Address;
import com.example.springdata1.entity.Role;
import com.example.springdata1.entity.User;
import com.example.springdata1.entity.dto.request.LoginRequest;
import com.example.springdata1.entity.dto.request.RefreshTokenRequest;
import com.example.springdata1.entity.dto.request.SignUpRequest;
import com.example.springdata1.entity.dto.response.LoginResponse;
import com.example.springdata1.service.AuthService;
import com.example.springdata1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/uaa")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class UaaController {

    private final AuthService authService;

    private final UserService userService;

    @Autowired
    public UaaController(AuthService authService, UserService userService) {
        this.authService = authService;

        this.userService = userService;
    }


    @PostMapping("/signin")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        var loginResponse = authService.login(loginRequest);
        return new ResponseEntity<LoginResponse>(
                loginResponse, HttpStatus.OK);
    }

    @PostMapping("/refreshToken")
    public LoginResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return authService.refreshToken(refreshTokenRequest);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignUpRequest signUpRequest) {
        User user=new User();
        user.setEmail(signUpRequest.getEmail());
        user.setFirstName(signUpRequest.getFirstName());
        user.setLastName(signUpRequest.getLastName());
        user.setPassword(signUpRequest.getPassword());

        Address address=new Address();
        address.setZip(signUpRequest.getZip());
        address.setCity(signUpRequest.getCity());
        user.setAddress(address);
        user.setRoles(new ArrayList<>());

        user = userService.add(user);

        return ResponseEntity.ok(user);
    }
}


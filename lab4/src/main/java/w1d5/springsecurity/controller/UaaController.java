package w1d5.springsecurity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import w1d5.springsecurity.entity.User;
import w1d5.springsecurity.entity.dto.request.LoginRequest;
import w1d5.springsecurity.entity.dto.request.RefreshTokenRequest;
import w1d5.springsecurity.entity.dto.response.LoginResponse;
import w1d5.springsecurity.service.AuthService;
import w1d5.springsecurity.service.UserService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/uaa")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UaaController {

    private final AuthService authService;

    private final UserService userService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        var loginResponse = authService.login(loginRequest);
        return new ResponseEntity<>(
                loginResponse, HttpStatus.OK);
    }

    @PostMapping("/refreshToken")
    public LoginResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return authService.refreshToken(refreshTokenRequest);
    }

    @PostMapping("signup")
    public User signup(@RequestBody User user){
        return userService.create(user);
    }

}

package lab4.security.controller;

import lab4.security.dto.AuthResponseDto;
import lab4.security.dto.LoginRequestDto;
import lab4.security.dto.SignupRequestDto;
import lab4.security.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {


    @Autowired
    private AuthService service;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponseDto> signup(@RequestBody SignupRequestDto request){
        System.out.println("generated/////////////////////////////////////////////////////////////////");

        return ResponseEntity.ok(service.signup(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> signup(@RequestBody LoginRequestDto request){
        return ResponseEntity.ok(service.login(request));
    }


}

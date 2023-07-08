package lab4.security.service;

import lab4.security.dto.AuthResponseDto;
import lab4.security.dto.LoginRequestDto;
import lab4.security.dto.SignupRequestDto;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    public AuthResponseDto signup(SignupRequestDto request);
    public AuthResponseDto login(LoginRequestDto request);
}

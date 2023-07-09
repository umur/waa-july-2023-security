package Demo1.demo.service;

import Demo1.demo.entity.DTO.request.LoginRequest;
import Demo1.demo.entity.DTO.request.RefreshTokenRequest;
import Demo1.demo.entity.DTO.response.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}

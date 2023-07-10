package w1d5.springsecurity.service;

import w1d5.springsecurity.entity.dto.request.LoginRequest;
import w1d5.springsecurity.entity.dto.request.RefreshTokenRequest;
import w1d5.springsecurity.entity.dto.response.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}

package cs545.Service;

import cs545.Domain.dto.UserRequest;
import cs545.Domain.dto.UserResponse;

public interface AuthService {
    UserResponse login(UserRequest loginRequest);
//    UserResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}

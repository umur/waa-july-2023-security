package cs545.Controller;


import cs545.Domain.dto.UserRequest;
import cs545.Domain.dto.UserResponse;
import cs545.Service.Impl.AuthServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/uaa")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UaaController {

    private final AuthServiceImpl authService;

    public UaaController(AuthServiceImpl authService) {

        this.authService = authService;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody UserRequest loginRequest) {
        var loginResponse = authService.login(loginRequest);
        return new ResponseEntity<UserResponse>(
                loginResponse, HttpStatus.OK);
    }

//    @PostMapping("/refreshToken")
//    public UserResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
//        return authService.refreshToken(refreshTokenRequest);
//    }

}


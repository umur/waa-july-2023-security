package online.moumini.spring.data.one.auth;

import online.moumini.spring.data.one.config.JwtUtilityService;
import online.moumini.spring.data.one.model.AppUser;
import online.moumini.spring.data.one.repository.AppUserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
  private final AppUserRepository appUserRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtUtilityService jwtUtilityService;
  private final AuthenticationManager authenticationManager;

  public AuthenticationResponse register(RegisterRequest request) {
    var user = AppUser.builder()
        .firstName(request.getFirstname())
        .lastName(request.getLastname())
        .username(request.getUsername())
        .email(request.getEmail())
        .password(passwordEncoder.encode(request.getPassword()))
        // .role(request.getRole())
        .build();
        appUserRepository.save(user);
    var jwtToken = jwtUtilityService.buildToken(new HashMap<>(), user);
    return AuthenticationResponse.builder()
        .accessToken(jwtToken)
        .build();
  }

  public AuthenticationResponse authenticate(RegisterRequest request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            request.getUsername(),
            request.getPassword()
        )
    );
    var user = appUserRepository.findByUsername(request.getUsername())
        .orElseThrow();
     var jwtToken = jwtUtilityService.buildToken(new HashMap<>(), user);
    return AuthenticationResponse.builder()
        .accessToken(jwtToken)
        .build();
  }
    
}

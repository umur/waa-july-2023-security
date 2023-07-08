package lab4.security.service.impl;

import lab4.security.dto.AuthResponseDto;
import lab4.security.dto.LoginRequestDto;
import lab4.security.dto.SignupRequestDto;
import lab4.security.entity.Role;
import lab4.security.entity.User;
import lab4.security.repository.RoleRepo;
import lab4.security.repository.UserRepo;
import lab4.security.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepo repository;
    @Autowired
    private RoleRepo roleRepository;
    @Autowired
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private final JwtServiceImpl jwtService;
    @Autowired
    private final AuthenticationManager authenticationManager;


    public AuthResponseDto signup(SignupRequestDto request) {
        List<Role> roles = Arrays.asList(roleRepository.findOneByName("USER"));

        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .roles(roles)
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        System.out.println("generated///////"+ roleRepository.findOneByName("USER").getName()+ " "+ user.getId());

        repository.save(user);

        String jwt = jwtService.generateToken(user);
        return AuthResponseDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .roles(user.getRoles())
                .token(jwt)
                .build();
    }

    public AuthResponseDto login(LoginRequestDto request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()
        ));
        User user = repository.findByEmail(request.getEmail()).orElseThrow();
        String jwt = jwtService.generateToken(user);

        return AuthResponseDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .roles(user.getRoles())
                .token(jwt)
                .build();
    }
}

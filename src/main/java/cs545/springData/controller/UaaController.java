package cs545.springData.controller;

import cs545.springData.dto.UserRequest;
import cs545.springData.dto.UserResponse;
import cs545.springData.entity.User;
import cs545.springData.security.JwtToken;
import cs545.springData.security.JwtUserDetailsService;
import cs545.springData.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/v1/authenticate")
//@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UaaController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    UserRepo userRepo;

    @Autowired
    private JwtToken jwtToken;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @PostMapping
    public ResponseEntity<?> createAuthenticationToken(@RequestBody UserRequest authenticationRequest)
            throws Exception {

        authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());
        final User customer = userRepo.findUserByEmail(userDetails.getUsername());
        final String token = jwtToken.generateToken(userDetails,customer.getId());

        return ResponseEntity.ok(new UserResponse(token));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
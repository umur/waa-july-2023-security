package cs545.Controller;

import cs545.Domain.User;
import cs545.Domain.dto.UserRequest;
import cs545.Domain.dto.UserResponse;
import cs545.Service.UserService;
import cs545.utility.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final JWTUtil jwtUtil;

    private final AuthenticationManager authenticationManager;
    public UserController(UserService userService, JWTUtil jwtUtil, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
    }


//    @PostMapping(value = "/login", consumes = "application/json")
//    public ResponseEntity<UserResponse> loginUser(@RequestBody UserRequest request) {
//
//        System.out.println(">>>>"+request);
//
//        //: validate usrname/pwd with DB
//        Authentication auth;
//        try{
//             auth = authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(
//                            request.getEmail(),
//                            request.getPassword()));
//            System.out.println(">>>>>>>> hello"+auth);
//            System.out.println("isAuthenticated >>>>> " + auth.isAuthenticated()+"    Role: "+auth.getAuthorities());
//
//        }catch (DisabledException ex){
//            System.out.println("Exception"+ex.getMessage());
//        }catch (LockedException ex){
//            System.out.println("Exception"+ex.getMessage());
//
//        }catch (BadCredentialsException ex){
//            System.out.println("Exception"+ex.getMessage());
//
//        }
//
//
//        String token = "Bearer " + jwtUtil.generateToken(request.getEmail());
//
//        return ResponseEntity.ok()
//                .body(new UserResponse(token, "success"));
//
//    }
    // GET /users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // GET /users/{id}
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    // POST /users

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    // PUT /users/{id}
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Integer id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    // DELETE /users/{id}
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }
}

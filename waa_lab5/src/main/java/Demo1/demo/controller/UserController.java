package Demo1.demo.controller;

import Demo1.demo.entity.User;
import Demo1.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public void addUser(User user) {
        userService.addUser(user);

        }
        @PutMapping("/update")
    public String updateUser(Long Id, User user) {
        userService.updateUser(user, Id) ;
            return "User updated";
        }
        @DeleteMapping("/delete")
    public void deleteUser(Long Id, User user) {
        userService.deleteUser(Id) ;

        }

        @GetMapping("/all")
    public void findAllUsers() {
        userService.getAllUsers();
        }



}

package com.waa.lab3.controller;

import com.waa.lab3.entity.User;
import com.waa.lab3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/addUsers")
    public String addUser(@RequestBody User user){
        return userService.addUser(user);
    }
    @GetMapping("/getUsers/{id}")
    public User getById(@PathVariable Long id){
        return userService.getById(id);
    }
    @GetMapping("/")
    public List<User> getAllBy(){
        return userService.getAllBy();
    }
    @PutMapping("updateUsers/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody User user){
        return userService.updateUser(id,user);
    }
    @DeleteMapping("deleteUsers/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return "user deleted";
    }
}

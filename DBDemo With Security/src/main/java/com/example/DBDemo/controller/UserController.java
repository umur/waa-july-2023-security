package com.example.DBDemo.controller;


import com.example.DBDemo.entity.User;
import com.example.DBDemo.reposiroty.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    final private UserRepository userRepository;

    @PostMapping
    public void saveUser(@RequestBody User user) {
        userRepository.save(user);
    }
}

package com.miu.waa.lab3.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miu.waa.lab3.entity.User;
import com.miu.waa.lab3.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    User create(@RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping("/{id}")
    User update(@PathVariable Integer id, @RequestBody User user) {
        user.setId(id);
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    User delete(@PathVariable Integer id) {
        return userService.delete(id);
    }

    @GetMapping
    List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    User findById(@PathVariable Integer id) {
        return userService.findById(id);
    }
}

package com.miu.waa.lab3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.miu.waa.lab3.entity.User;
import com.miu.waa.lab3.repo.UserRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    public User findById(Integer id) {
        Optional<User> optionalUser = userRepo.findById(id);

        if (!optionalUser.isPresent()) {
            throw new RuntimeException("User is not found.");
        }

        return optionalUser.get();
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public User create(User user) {
        return userRepo.save(user);
    }

    public User update(User user) {
        User tempUser = findById(user.getId());

        tempUser.setEmail(user.getEmail());
        tempUser.setPassword(user.getPassword());
        tempUser.setFirstName(user.getFirstName());
        tempUser.setLastName(user.getLastName());
        tempUser.setAddress(user.getAddress());

        return userRepo.save(tempUser);
    }

    public User delete(Integer id) {
        User tempUser = findById(id);
        userRepo.delete(tempUser);

        return tempUser;
    }

}

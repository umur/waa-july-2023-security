package com.example.DBDemo.service;

import com.example.DBDemo.entity.User;
import com.example.DBDemo.reposiroty.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    final private UserRepository userRepository;

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }
}

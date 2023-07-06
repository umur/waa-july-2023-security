package com.example.lab5.repository;

import com.example.lab5.entity.User;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends ListCrudRepository<User, Integer> {
    User findByUserName(String userName);
}

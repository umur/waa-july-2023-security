package com.waa.lab3.repository;

import com.waa.lab3.entity.User;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends ListCrudRepository<User,Long> {
    User findByEmail(String email);
}

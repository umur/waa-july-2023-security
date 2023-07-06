package com.miu.springsecurity.repository;

import com.miu.springsecurity.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User,Integer> {
public User findByEmail(String username);


}

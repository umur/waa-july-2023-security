package com.miu.waa.lab3.repo;

import org.springframework.data.repository.ListCrudRepository;

import com.miu.waa.lab3.entity.User;

public interface UserRepo extends ListCrudRepository<User, Integer> {

}

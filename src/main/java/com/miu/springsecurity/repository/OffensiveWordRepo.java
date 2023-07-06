package com.miu.springsecurity.repository;

import com.miu.springsecurity.entity.OffensiveUser;
import org.springframework.data.repository.CrudRepository;

public interface OffensiveWordRepo extends CrudRepository<OffensiveUser,Integer> {
    OffensiveUser findOffensiveUserByUser_Id(int userId);
}

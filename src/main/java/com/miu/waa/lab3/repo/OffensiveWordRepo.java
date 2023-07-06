package com.miu.waa.lab3.repo;

import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;

import com.miu.waa.lab3.entity.OffensiveWord;

public interface OffensiveWordRepo extends ListCrudRepository<OffensiveWord, Integer> {
    Optional<OffensiveWord> findByUserEmail(String email);
}

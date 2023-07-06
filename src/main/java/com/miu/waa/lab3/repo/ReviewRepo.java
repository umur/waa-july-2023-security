package com.miu.waa.lab3.repo;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import com.miu.waa.lab3.entity.Review;

public interface ReviewRepo extends ListCrudRepository<Review, Integer> {
    List<Review> findByProductIdEquals(Long id);
}

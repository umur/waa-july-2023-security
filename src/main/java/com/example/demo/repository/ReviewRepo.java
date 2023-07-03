package com.example.demo.repository;

import com.example.demo.entity.Review;
import org.springframework.data.repository.ListCrudRepository;

public interface ReviewRepo extends ListCrudRepository<Review, Long> {
}

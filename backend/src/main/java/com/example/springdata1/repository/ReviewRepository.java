package com.example.springdata1.repository;

import com.example.springdata1.entity.Review;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends ListCrudRepository<Review, Long> {
}

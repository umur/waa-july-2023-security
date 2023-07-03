package com.example.springdata1.service;

import com.example.springdata1.entity.Review;

import java.util.List;


public interface ReviewService {
    List<Review> findAll();

    Review findById(Long id);

    Review add(Review review);

    Review update(Review review);

    void delete(Long id);

}

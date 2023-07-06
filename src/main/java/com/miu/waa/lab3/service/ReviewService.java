package com.miu.waa.lab3.service;

import java.util.List;

import com.miu.waa.lab3.entity.Review;

public interface ReviewService {
    Review findById(Integer id);

    List<Review> findAll();

    Review create(Review review);

    Review update(Review review);

    Review delete(Integer id);

    List<Review> findByProductId(Long productId);
}
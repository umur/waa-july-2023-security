package com.waa.lab3.service;

import com.waa.lab3.entity.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getByProductId(Long productId);
    String addReview(Review review);

    Review getById(Long id);

    List<Review> getAllBy();

    String updateReview(Long id, Review rev);

    String deleteReview(Long id);

}

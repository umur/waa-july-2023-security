package com.example.DBDemo.service;

import com.example.DBDemo.entity.Review;

import java.util.List;

public interface ReviewService {

    void saveReview(Review review);

    List<Review> getAll();
}

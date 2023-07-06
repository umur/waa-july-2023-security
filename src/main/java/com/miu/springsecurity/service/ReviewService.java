package com.miu.springsecurity.service;

import com.miu.springsecurity.dto.ReviewDto;
import com.miu.springsecurity.entity.Review;

import java.util.List;

public interface ReviewService {
    void save(Review review);
    List<ReviewDto> findAll();
    ReviewDto findById(int id);
    void deleteById(int id);

    List<ReviewDto> reviewsByProductId(int id);
}

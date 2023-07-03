package com.example.demo.service.impl;

import com.example.demo.entity.Review;
import com.example.demo.repository.ReviewRepo;
import com.example.demo.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {


    private final ReviewRepo reviewRepo;

    public void create(Review review) {
        reviewRepo.save(review);
    }

    public List<Review> findAll() {
        return reviewRepo.findAll();
    }

    @Override
    public void update(Review review) {
        reviewRepo.save(review);
    }

    @Override
    public Review getReview(Long id) {
        return reviewRepo.findById(id).orElseGet(null);
    }

    @Override
    public void delete(Review review) {
        reviewRepo.delete(review);
    }
}

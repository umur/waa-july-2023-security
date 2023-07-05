package com.miu.waa.lab3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.miu.waa.lab3.entity.Review;
import com.miu.waa.lab3.repo.ReviewRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepo reviewRepo;

    public Review findById(Integer id) {
        Optional<Review> optionalReview = reviewRepo.findById(id);

        if (!optionalReview.isPresent()) {
            throw new RuntimeException("Review is not found.");
        }

        return optionalReview.get();
    }

    public List<Review> findAll() {
        return reviewRepo.findAll();
    }

    public Review create(Review review) {
        return reviewRepo.save(review);
    }

    public Review update(Review review) {
        Review tempReview = findById(review.getId());

        tempReview.setText(review.getText());

        return reviewRepo.save(tempReview);
    }

    public Review delete(Integer id) {
        Review tempReview = findById(id);
        reviewRepo.delete(tempReview);
        return tempReview;
    }

    public List<Review> findByProductId(Long productId) {
        return reviewRepo.findByProductIdEquals(productId);
    }
}

package com.example.springdata1.service.impl;

import com.example.springdata1.entity.Review;
import com.example.springdata1.repository.ReviewRepository;
import com.example.springdata1.service.ReviewService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@AllArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Review findById(Long id) {
        return reviewRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid review id: " + id));
    }

    @Override
    public Review add(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Review update(Review review) {
        Review existingReview = reviewRepository.findById(review.getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid review id: " + review.getId()));
        existingReview.setComment(review.getComment());
        existingReview.setUser(review.getUser());
        existingReview.setProduct(review.getProduct());

        Review updatedReview = reviewRepository.save(existingReview);
        return updatedReview;
    }

    @Override
    public void delete(Long id) {
        reviewRepository.deleteById(id);
    }
}

package com.example.DBDemo.service;

import com.example.DBDemo.entity.Review;
import com.example.DBDemo.reposiroty.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {

    final private ReviewRepository reviewRepository;

    @Override
    public void saveReview(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public List<Review> getAll() {
        return reviewRepository.findAll();
    }
}

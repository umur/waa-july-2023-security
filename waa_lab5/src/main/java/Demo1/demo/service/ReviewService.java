package Demo1.demo.service;

import Demo1.demo.entity.Review;

import java.util.List;

public interface ReviewService {


    void addReview(Review review);

    void updateReview(Long Id, Review review);

    void deleteReview(Long Id);
    abstract void getAllReviews();
    List<Review> findAllReviewsById(Long productId);
}

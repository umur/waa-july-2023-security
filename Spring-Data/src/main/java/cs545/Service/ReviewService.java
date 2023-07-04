package cs545.Service;

import cs545.Domain.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews();
    Review getReviewById(Integer id);
    Review createReview(Review review);
    Review updateReview(Integer id, Review review);
    void deleteReview(Integer id);
}

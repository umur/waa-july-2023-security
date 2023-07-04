package cs545.Service.Impl;

import cs545.DAO.ReviewRepo;
import cs545.Domain.Review;
import cs545.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepo reviewRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepo reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Review getReviewById(Integer id) {
        return reviewRepository.findById(id).get();
    }

    @Override
    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Review updateReview(Integer id, Review review) {
        Review existingReview = getReviewById(id);
        existingReview.setComment(review.getComment());
        return reviewRepository.save(existingReview);
    }

    @Override
    public void deleteReview(Integer id) {
        Review review = getReviewById(id);
        reviewRepository.delete(review);
    }
}

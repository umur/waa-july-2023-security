package online.moumini.spring.data.one.service;
import online.moumini.spring.data.one.model.Review;
import online.moumini.spring.data.one.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.Optional;

import javax.transaction.Transactional;

@Transactional
@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public Iterable<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Optional<Review> getReviewById(Long id) {
        return reviewRepository.findById(id);
    }

    public Iterable<Review> getByProductId(Long product_id) {
        return reviewRepository.findByReviewId_Product_Id(product_id);
    }

    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

    public Pair<Boolean, Review> EditReview(Review review) {
        boolean exists = reviewRepository.existsByReviewId(review.getReviewId());
        reviewRepository.save(review);
        return Pair.of(exists, review);
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}

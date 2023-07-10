package w1d5.springsecurity.service;

import org.springframework.stereotype.Service;
import w1d5.springsecurity.entity.Review;
import w1d5.springsecurity.repository.ReviewRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService{

    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review create(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Review findById(Long id) {
        return reviewRepository.findById(id).orElse(null);
    }

    @Override
    public Review update(Long id, Review review) {
        Optional<Review> optionalReview = reviewRepository.findById(id);
        if(optionalReview.isPresent()){
            optionalReview.get().setComment(review.getComment());
            optionalReview.get().setUser(review.getUser());
            optionalReview.get().setProduct(review.getProduct());
        }
        return optionalReview.orElse(null);
    }

    @Override
    public void delete(Long id) {
        reviewRepository.deleteById(id);
    }
}

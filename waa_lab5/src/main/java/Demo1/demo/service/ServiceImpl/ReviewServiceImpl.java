package Demo1.demo.service.ServiceImpl;

import Demo1.demo.entity.Review;
import Demo1.demo.repository.ReviewRepository;
import Demo1.demo.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

@Autowired
private ReviewRepository reviewRepository;

    @Override
    public void addReview(Review review) {
       reviewRepository.save(review);

    }
    @Override
    public void updateReview(Long Id, Review review) {
      reviewRepository.findById(Id).map(review1 -> {
          review1.setComment(review.getComment());
          return reviewRepository.save(review1);
      });
    }

    @Override
    public void deleteReview(Long Id) {
        reviewRepository.deleteById(Id);
    }

    @Override
    public void getAllReviews() {
        reviewRepository.findAll();
    }

    @Override
    public List<Review> findAllReviewsById(Long productId) {
        return reviewRepository.findAllReviewsById(productId);
    }

}

package lab4.security.service;

import lab4.security.entity.Review;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface ReviewService {

    public List<Review> getAll();
    public Optional<Review> findById(Long id);
    public Review create(Review review);
    public Optional<Review>  update(Long id, Review review);
    public void deleteById(Long id);

    List<Review> getReviewsByProductId(Long reviewId);

}

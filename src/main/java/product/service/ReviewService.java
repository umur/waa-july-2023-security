package product.service;

import product.dto.review.CreateReviewDto;
import product.dto.review.UpdateReviewDto;
import product.entity.Review;

import java.util.List;

public interface ReviewService {
    List<Review> findAll();

    List<Review> findAllByProductId(Long productId);

    Review findById(Long id);

    Review create(CreateReviewDto reviewDto);

    Review update(UpdateReviewDto reviewDto);

    Review delete(Long id);
}

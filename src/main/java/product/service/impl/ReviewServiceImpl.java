package product.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import product.annotation.ProfanityFilter;
import product.dto.review.CreateReviewDto;
import product.dto.review.UpdateReviewDto;
import product.entity.Review;
import product.entity.User;
import product.repository.ReviewRepo;
import product.service.ReviewService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepo reviewRepo;

    private final ModelMapper modelMapper;

    @Override
    public List<Review> findAll(){
        return reviewRepo.findAll();
    }

    @Override
    public List<Review> findAllByProductId(Long productId){
        return reviewRepo.findAllByProduct_Id(productId);
    }

    @Override
    public Review findById(Long id){
        return reviewRepo.findById(id).get();
    }

    @Override
    @ProfanityFilter
    public Review create(CreateReviewDto reviewDto){
        Review review = modelMapper.map(reviewDto, Review.class);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        review.setUser(user);
        return reviewRepo.save(review);
    }

    @Override
    public Review update(UpdateReviewDto reviewDto){
        Review review = findById(reviewDto.getId());
        modelMapper.map(reviewDto, review);
        return reviewRepo.save(review);
    }

    @Override
    public Review delete(Long id){
        Review review = findById(id);
        reviewRepo.delete(review);
        return review;
    }
}

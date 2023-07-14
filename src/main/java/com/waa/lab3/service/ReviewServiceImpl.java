package com.waa.lab3.service;
import com.waa.lab3.entity.Review;
import com.waa.lab3.repository.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepo reviewRepo;

    @Override
    public List<Review> getByProductId(Long productId) {
        return reviewRepo.findByProductId(productId);
    }

    @Override
    public String addReview(Review review){
        reviewRepo.save(review);
        return "review added";
    }
    @Override
    public Review getById(Long id){
        Optional<Review> addr= reviewRepo.findById(id);
        if(addr.isPresent())return addr.get();
        else return null;
    }
    @Override
    public List<Review> getAllBy(){
        return reviewRepo.findAll();
    }
    @Override
    public String updateReview(Long id, Review rev){
        Optional<Review>review=reviewRepo.findById(id);
        if(review.isPresent()){
            Review r=review.get();
            r.setComment(rev.getComment());
            r.setProduct(rev.getProduct());
            r.setUser(rev.getUser());
            reviewRepo.save(r);
        }
        return "review updated";
    }
    @Override
    public String deleteReview(Long id){
        reviewRepo.deleteById(id);
        return "review deleted";
    }

}

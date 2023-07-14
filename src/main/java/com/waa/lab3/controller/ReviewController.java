package com.waa.lab3.controller;
import com.waa.lab3.entity.Review;
import com.waa.lab3.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @PostMapping("reviews")
    public String addReview(@RequestBody Review review){
        return reviewService.addReview(review);
    }
    @GetMapping("reviews/{id}")
    public Review getById(@PathVariable Long id){
        return reviewService.getById(id);
    }
    @GetMapping("reviews")
    public List<Review> getAllBy(){
        return reviewService.getAllBy();
    }
    @PostMapping("reviews/{id}")
    public String updateReview(@PathVariable Long id, @RequestBody Review rev){

        return reviewService.updateReview(id, rev);
    }
    @DeleteMapping("/reviews")
    public String deleteReview(@PathVariable Long id){
        return reviewService.deleteReview(id);
    }

    @GetMapping("/reviewsById/{id}")
    public List<Review> getReviewByPId(@PathVariable Long id) {
        return reviewService.getByProductId(id);
    }
}

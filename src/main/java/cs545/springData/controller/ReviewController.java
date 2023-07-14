package cs545.springData.controller;

import cs545.springData.service.ReviewService;
import cs545.springData.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping("/reviews")
    public List<Review> getReview(){
        return reviewService.getReview();
    }
    @PostMapping("/reviews")
    public Review addReview(@RequestBody Review review){
        reviewService.addReview(review);
        return review;
    }
    @GetMapping("/reviews/{id}")
    public Review getReviewById(@PathVariable Long id){
        return reviewService.getById(id);
    }

    @GetMapping("/reviews/{ProductId}")
    public List<Review> findByProductId(@PathVariable Long productId){
        return reviewService.findByProductId(productId);

    }

    @PutMapping("/reviews/{id}")
    public Review updateReview(@PathVariable Long id,@RequestBody Review review){
        return reviewService.updateReview(id,review);

    }
    @DeleteMapping("/review/{id}")
    public String deleteById(@PathVariable Long id){
        return reviewService.DeleteById(id);
    }
}

package Demo1.demo.controller;

import Demo1.demo.entity.Review;
import Demo1.demo.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/add")
    public void addReview(@RequestBody Review review){
        reviewService.addReview(review);
    }
    @PutMapping("/update")
    public String updateReview(Long Id, @RequestBody Review review){
        reviewService.updateReview(Id, review);
        return "Review updated";
    }
    @DeleteMapping("/delete")
    public void deleteReview(Long Id){
        reviewService.deleteReview(Id);
    }
    @GetMapping("/all")
    public void findAllReview(){
        reviewService.getAllReviews();
    }

    @GetMapping("/all/{Id}")
    public List<Review> findAllReviewByProductId(@PathVariable Long Id){
        return reviewService.findAllReviewsById(Id);
    }

}

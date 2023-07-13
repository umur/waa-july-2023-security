package product.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import product.dto.review.CreateReviewDto;
import product.dto.review.UpdateReviewDto;
import product.entity.Review;
import product.service.ReviewService;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ADMIN')")
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping
    public List<Review> findAll(){
        return reviewService.findAll();
    }

    @GetMapping("{id}")
    public Review findById(Long id){
        return reviewService.findById(id);
    }

    @PostMapping
    public Review create(@RequestBody CreateReviewDto reviewDto){
        return reviewService.create(reviewDto);
    }

    @PutMapping("{id}")
    public Review update(@PathVariable Long id, @RequestBody UpdateReviewDto reviewDto){
        reviewDto.setId(id);
        return reviewService.update(reviewDto);
    }

    @DeleteMapping("{id}")
    public Review delete(@PathVariable Long id){
        return reviewService.delete(id);
    }

}

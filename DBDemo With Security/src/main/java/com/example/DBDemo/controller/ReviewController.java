package com.example.DBDemo.controller;

import com.example.DBDemo.entity.Review;
import com.example.DBDemo.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reviews")
public class ReviewController {

    final private ReviewService reviewService;

    @PostMapping
    public void addReview(@RequestBody Review review){
        reviewService.saveReview(review);
    }


    @GetMapping
    public List<Review> getAll(){
        return reviewService.getAll();
    }
}

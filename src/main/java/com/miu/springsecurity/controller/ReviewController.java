package com.miu.springsecurity.controller;

import com.miu.springsecurity.dto.ReviewDto;
import com.miu.springsecurity.entity.Review;
import com.miu.springsecurity.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping
    public void save(@RequestBody Review review) {
        reviewService.save(review);
    }

    @GetMapping
    public List<ReviewDto> findAll() {
        return reviewService.findAll();
    }

    @GetMapping("/{id}")
    public ReviewDto findById(@PathVariable int id) {
        return reviewService.findById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Review review) {
        if (id > 0)
            review.setId(id);
        reviewService.save(review);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        reviewService.deleteById(id);
    }

    @GetMapping("/product/{id}")
    public List<ReviewDto> reviewsByProductId(@PathVariable int id){
       return reviewService.reviewsByProductId(id);
    }
}

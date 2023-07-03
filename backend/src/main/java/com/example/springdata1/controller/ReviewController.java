package com.example.springdata1.controller;

import com.example.springdata1.entity.Review;
import com.example.springdata1.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> add(@RequestBody Review review) {

        Review createdReview = reviewService.add(review);
        return new ResponseEntity<>(createdReview, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getById(@PathVariable Long id) {
        Review review = reviewService.findById(id);
        return new ResponseEntity<>(review, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAll() {
        List<Review> reviews = reviewService.findAll();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public void update(@PathVariable Long id, @RequestBody Review review) {
        if (id != review.getId()) {
            throw new IllegalArgumentException("Id does not match review id");
        }
        reviewService.update(review);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        reviewService.delete(id);
    }
}

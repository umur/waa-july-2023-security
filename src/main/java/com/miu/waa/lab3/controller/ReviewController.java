package com.miu.waa.lab3.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miu.waa.lab3.entity.Review;
import com.miu.waa.lab3.service.ReviewService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping
    Review create(@RequestBody Review review) {
        return reviewService.create(review);
    }

    @PutMapping("/{id}")
    Review update(@PathVariable Integer id, @RequestBody Review review) {
        review.setId(id);
        return reviewService.update(review);
    }

    @DeleteMapping("/{id}")
    Review delete(@PathVariable Integer id) {
        return reviewService.delete(id);
    }

    @GetMapping
    List<Review> findAll() {
        return reviewService.findAll();
    }

    @GetMapping("/{id}")
    Review findById(@PathVariable Integer id) {
        return reviewService.findById(id);
    }
}

package com.example.lab5.controller;

import com.example.lab5.entity.Product;
import com.example.lab5.entity.Review;
import com.example.lab5.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public void save(@RequestBody Product p) {
        productService.save(p);
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_CLIENT')")
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable int id) {
        var product = productService.getById(id);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        productService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") int productId) {
        productService.update(productId);
    }

    @GetMapping("/{id}/reviews")
    public ResponseEntity<Review> getReviewsByProductId(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
    }
}

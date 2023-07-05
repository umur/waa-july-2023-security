package com.example.DBDemo.controller;

import com.example.DBDemo.entity.Product;
import com.example.DBDemo.entity.Review;
import com.example.DBDemo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    final private ProductService productService;

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @PostMapping
    public void addProduct(@RequestBody Product product) {
        productService.saveProduct(product);
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping
    public List<Product> getAll() throws RuntimeException {
        return productService.getAll();
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping("/{id}/reviews")
    public List<Review> findAllReviewsByProductId(@PathVariable long id) {
        return productService.findAllReviewsByProductId(id);
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping("/minPrice")
    public List<Product> findAllByPriceGreaterThan(@RequestParam int price) {
        return productService.findAllByPriceGreaterThan(price);
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping("/minPriceAndCategoryContains")
    public List<Product> findAllByPriceGreaterThanAndCategory_Name(@RequestParam int price, @RequestParam String name) {
        return productService.findAllByPriceGreaterThanAndCategory_Name(price, name);
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping("/nameContains")
    public List<Product> findAllByNameContains(@RequestParam String name) {
        return productService.findAllByNameContains(name);
    }
}

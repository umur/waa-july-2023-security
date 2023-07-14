package com.waa.lab3.controller;

import com.waa.lab3.entity.Category;
import com.waa.lab3.entity.Product;
import com.waa.lab3.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @PostMapping("/products")
    public String addProduct(@RequestBody Product product){
        productService.addProduct(product);
        return "product added";
    }
    @GetMapping("/products/{id}")
    public Product getById(@PathVariable Long id){
        return productService.getById(id);
    }
    @GetMapping("/products")
    public List<Product> getAllBy(){
        return productService.getAllBy();
    }
    @PutMapping("/products/{id}")
    public String updateProduct(@PathVariable Long id,@RequestBody Product pdt){
        return productService.updateProduct(id,pdt);
    }
    @DeleteMapping("/products/{id}")
    public String deleteAddress(@PathVariable Long id){
        return productService.deleteAddress(id);
    }
    @GetMapping("/productsByMinPrice/{minPrice}")
    public List<Product> getProductByMinPrice(@PathVariable double minPrice) {
        return productService.getByPriceGreaterThan(minPrice);
    }

    @GetMapping("/productsByKeyword/{keyword}")
    public List<Product> getProductBy(@PathVariable String keyword) {
        return productService.getByNameContaining(keyword);
    }

    @GetMapping("/productByCategoryByMaxPrice/{maxPrice}")
    public List<Product> getProductByMaxPrice(@RequestBody Category cat, @PathVariable double maxPrice) {
        return productService.getByCategoryAndPriceLessThan(cat, maxPrice);
    }
}

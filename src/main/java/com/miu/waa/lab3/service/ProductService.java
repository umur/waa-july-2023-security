package com.miu.waa.lab3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.miu.waa.lab3.entity.Product;
import com.miu.waa.lab3.repo.ProductRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepo productRepo;

    public Product findById(Integer id) {
        Optional<Product> optionalProduct = productRepo.findById(id);

        if (!optionalProduct.isPresent()) {
            throw new RuntimeException("Product is not found.");
        }

        return optionalProduct.get();
    }

    public List<Product> findAll() {
        return productRepo.findAll();
    }

    public Product create(Product product) {
        return productRepo.save(product);
    }

    public Product update(Product product) {
        Product tempProduct = findById(product.getId());

        tempProduct.setName(product.getName());
        tempProduct.setPrice(product.getPrice());
        tempProduct.setRating(product.getRating());
        tempProduct.setReviews(product.getReviews());
        tempProduct.setCategory(product.getCategory());

        return productRepo.save(tempProduct);
    }

    public Product delete(Integer id) {
        Product tempProduct = findById(id);
        productRepo.delete(tempProduct);
        return tempProduct;
    }

    public List<Product> findByPrice(Double price) {
        return productRepo.findByPriceGreaterThan(price);
    }

    public List<Product> findByPriceAndCategory(Double price, String categoryName) {
        return productRepo.findByPriceLessThanAndCategoryNameEquals(price, categoryName);
    }

    public List<Product> findByName(String name) {
        return productRepo.findByNameContains(name);
    }
}

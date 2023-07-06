package com.miu.waa.lab3.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.miu.waa.lab3.aspect.annotation.OffensiveWord;
import com.miu.waa.lab3.entity.Product;
import com.miu.waa.lab3.entity.User;
import com.miu.waa.lab3.repo.ProductRepo;
import com.miu.waa.lab3.service.ProductService;
import com.miu.waa.lab3.util.SecurityUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;
    private final SecurityUtil securityUtil;

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

    @OffensiveWord
    public Product create(Product product) {
        User user = securityUtil.getCurrentUser();
        product.setCreatedUser(user);
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

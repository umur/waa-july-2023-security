package com.example.DBDemo.service;

import com.example.DBDemo.entity.Product;
import com.example.DBDemo.entity.Review;

import java.util.List;

public interface ProductService {

    void saveProduct(Product product);
    List<Product> getAll();

    List<Product> findAllByPriceGreaterThan(int price);

    List<Product> findAllByPriceGreaterThanAndCategory_Name(int price, String name);

    List<Product> findAllByNameContains(String name);

    List<Review> findAllReviewsByProductId(long id);
}

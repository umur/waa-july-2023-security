package com.example.demo.service;

import com.example.demo.entity.Product;

import java.util.List;

public interface ProductService {
    void create(Product product);

    List<Product> findAll();

    void update(Product product);

    Product getProduct(Long id);

    void delete(Product product);

    List<Product> findAllByPriceGreaterThan(int minPrice);

    List<Product> findAllByNameContains(String keyword);
}

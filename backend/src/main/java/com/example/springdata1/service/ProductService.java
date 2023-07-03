package com.example.springdata1.service;

import com.example.springdata1.entity.Product;

import java.util.List;


public interface ProductService {
    List<Product> findAll();

    Product findById(Long id);

    Product add(Product product);

    Product update(Product product);

    void delete(Long id);

    List<Product> findAllCostsMoreThanMinPrice(Double minPrice);
    List<Product> findAllInCategoryCostsLessThanMaxPrice(Long categoryId,Double maxPrice);
    List<Product> findAllByKeyword(String keyword);
}

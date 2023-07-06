package com.miu.waa.lab3.service;

import java.util.List;

import com.miu.waa.lab3.entity.Product;

public interface ProductService {
    Product findById(Integer id);
    List<Product> findAll();
    Product create(Product product);
    Product update(Product product);
    Product delete(Integer id);
    List<Product> findByPrice(Double price);
    List<Product> findByPriceAndCategory(Double price, String categoryName);
    List<Product> findByName(String name);
}

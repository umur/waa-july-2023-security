package com.miu.springsecurity.service;

import com.miu.springsecurity.dto.ProductDto;
import com.miu.springsecurity.entity.Product;

import java.util.List;

public interface ProductService {
    void save(Product product);
    List<ProductDto> findAll();
    ProductDto findById(int id);
    void deleteById(int id);

    List<ProductDto> findProductsMoreThanMinPrice(double minPrice);

    List<ProductDto> findByCategoryAnAndPriceLessThan(String cat, double maxPrice);

    List<ProductDto> findByNameContains(String keyword);
}

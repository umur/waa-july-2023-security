package com.miu.waa.lab3.repo;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import com.miu.waa.lab3.entity.Product;

public interface ProductRepo extends ListCrudRepository<Product, Integer> {
    List<Product> findByPriceGreaterThan(Double price);
    List<Product> findByPriceLessThanAndCategoryNameEquals(Double price, String categoryName);
    List<Product> findByNameContains(String name);
}

package com.waa.lab3.service;

import com.waa.lab3.entity.Category;
import com.waa.lab3.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getByPriceGreaterThan(double minPrice);
    List<Product> getByNameContaining(String keyword);
    List<Product> getByCategoryAndPriceLessThan(Category category, double maxPrice);

    String addProduct(Product product);

    Product getById(Long id);

    List<Product> getAllBy();

    String updateProduct(Long id, Product pdt);

    String deleteAddress(Long id);

}

package com.example.springdata1.repository;

import com.example.springdata1.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends ListCrudRepository<Product, Long> {
    List<Product> findByPriceGreaterThan(Double minCost);

    List<Product> findByCategory_IdAndPriceLessThan(Long categoryId, Double minCost);

    List<Product> findByNameContainingIgnoreCase(String keyword);
}

package com.example.demo.repository;

import com.example.demo.entity.Product;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends ListCrudRepository<Product, Long> {

    List<Product> findAllByPriceGreaterThan(int minPrice);

    List<Product> findAllByNameContains(String keyword);

}

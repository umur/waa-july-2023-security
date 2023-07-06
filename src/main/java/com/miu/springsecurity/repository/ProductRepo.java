package com.miu.springsecurity.repository;

import com.miu.springsecurity.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends CrudRepository<Product,Integer> {
    List<Product> findByPriceGreaterThan(double minPrice);
    List<Product> findByCategory_NameIgnoreCaseAndPriceLessThan(String cat, double maxPrice);

    List<Product> findByNameContainsIgnoreCase(String keyword);
}

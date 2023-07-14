package com.waa.lab3.repository;
import com.waa.lab3.entity.Category;
import com.waa.lab3.entity.Product;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends ListCrudRepository<Product,Long> {
    List<Product> findByPriceGreaterThan(double minPrice);
    List<Product> findByNameContaining(String keyword);
    List<Product> findByCategoryAndPriceLessThan(Category category, double maxPrice);
}

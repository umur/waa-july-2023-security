package com.example.DBDemo.reposiroty;


import com.example.DBDemo.entity.Product;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends ListCrudRepository<Product, Long> {

    List<Product> findAllByPriceGreaterThan(int price);

    List<Product> findAllByPriceGreaterThanAndCategory_Name(int price, String name);

    List<Product> findAllByNameContains(String name);

    Product findById(long id);
}

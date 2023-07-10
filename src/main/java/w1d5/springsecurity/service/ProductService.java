package w1d5.springsecurity.service;

import w1d5.springsecurity.entity.Product;

import java.util.List;

public interface ProductService {
    Product create(Product product);

    List<Product> findAll();

    Product findById(Long id);

    Product update(Long id, Product product);

    void delete(Long id);
}

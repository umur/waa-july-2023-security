package com.example.lab5.service;


import com.example.lab5.entity.Product;

import java.util.List;

public interface ProductService {
    void save(Product p);

    void delete(int id);

    Product update(int d);

    Product getById(int id);

    List<Product> getAll();
}


package com.example.lab5.service.Impl;

import com.example.lab5.entity.Product;
import com.example.lab5.repository.ProductRepo;
import com.example.lab5.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepo productRepo;

    @Override
    public void save(Product p) {
        productRepo.save(p);
    }

    @Override
    public void delete(int id) {
        productRepo.deleteById(id);
    }

    @Override
    public Product update(int id) {
        Product product = getById(id);
        productRepo.save(product);
        return product;
    }

    @Override
    public Product getById(int id) {
        Optional<Product> product = productRepo.findById(id);
        if (product.isEmpty()) {
            throw new NoSuchElementException();
        }
        return product.get();
    }

    public List<Product> getAll() {
        return new ArrayList<>(productRepo.findAll());
    }
}

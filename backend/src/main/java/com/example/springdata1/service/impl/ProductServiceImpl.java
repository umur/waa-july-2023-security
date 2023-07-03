package com.example.springdata1.service.impl;

import com.example.springdata1.entity.Product;
import com.example.springdata1.repository.ProductRepository;
import com.example.springdata1.service.ProductService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;


    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid product id: " + id));
    }

    @Override
    public Product add(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product) {
        Product existingProduct = productRepository.findById(product.getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid product id: " + product.getId()));
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setRating(product.getRating());

        Product updatedProduct = productRepository.save(existingProduct);
        return updatedProduct;
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findAllCostsMoreThanMinPrice(Double minPrice) {
        return productRepository.findByPriceGreaterThan(minPrice);
    }

    @Override
    public List<Product> findAllInCategoryCostsLessThanMaxPrice(Long categoryId, Double maxPrice) {
        return productRepository.findByCategory_IdAndPriceLessThan(categoryId, maxPrice);
    }

    @Override
    public List<Product> findAllByKeyword(String keyword) {
        return productRepository.findByNameContainingIgnoreCase(keyword);
    }
}

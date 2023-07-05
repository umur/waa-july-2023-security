package com.example.DBDemo.service;

import com.example.DBDemo.entity.Product;
import com.example.DBDemo.entity.Review;
import com.example.DBDemo.reposiroty.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findAllByPriceGreaterThan(int price) {
        return productRepository.findAllByPriceGreaterThan(price);
    }

    @Override
    public List<Product> findAllByPriceGreaterThanAndCategory_Name(int price, String name) {
        return productRepository.findAllByPriceGreaterThanAndCategory_Name(price, name);
    }

    @Override
    public List<Product> findAllByNameContains(String name) {
        return productRepository.findAllByNameContains(name);
    }

    @Override
    public List<Review> findAllReviewsByProductId(long id) {
        return productRepository.findById(id).getReviews();
    }


}

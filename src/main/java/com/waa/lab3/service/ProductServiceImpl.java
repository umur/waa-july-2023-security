package com.waa.lab3.service;
import com.waa.lab3.entity.Category;
import com.waa.lab3.entity.Product;
import com.waa.lab3.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<Product> getByPriceGreaterThan(double minPrice) {
        return productRepo.findByPriceGreaterThan(minPrice);
    }
    @Override
    public List<Product> getByNameContaining(String keyword) {
        return productRepo.findByNameContaining(keyword);
    }
    @Override
    public List<Product> getByCategoryAndPriceLessThan(Category category, double maxPrice) {
        return productRepo.findByCategoryAndPriceLessThan(category,maxPrice);
    }
    @Override
    public String addProduct(Product product){
        productRepo.save(product);
        return "product added";
    }
    @Override
    public Product getById(Long id){
        Optional<Product> addr= productRepo.findById(id);
        if(addr.isPresent())return addr.get();
        else return null;
    }
    @Override
    public List<Product> getAllBy(){
        return productRepo.findAll();
    }
    @Override
    public String updateProduct(Long id, Product pdt){
        Optional<Product>product=productRepo.findById(id);
        if(product.isPresent()){
            Product p=product.get();
            p.setName(pdt.getName());
            p.setRating(pdt.getRating());
            p.setPrice(pdt.getPrice());
            p.setCategory(pdt.getCategory());
            p.setReview(pdt.getReview());
            productRepo.save(p);
        }
        return "product updated";
    }
    @Override
    public String deleteAddress(Long id){
        productRepo.deleteById(id);
        return "product deleted";
    }
}

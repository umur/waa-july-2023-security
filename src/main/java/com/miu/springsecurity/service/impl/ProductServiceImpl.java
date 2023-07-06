package com.miu.springsecurity.service.impl;

import com.miu.springsecurity.aspect.annotation.ExecutionTime;
import com.miu.springsecurity.aspect.annotation.OffensiveWord;
import com.miu.springsecurity.dto.ProductDto;
import com.miu.springsecurity.entity.Product;
import com.miu.springsecurity.entity.User;
import com.miu.springsecurity.repository.ProductRepo;
import com.miu.springsecurity.security.AwesomeUserDetails;
import com.miu.springsecurity.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;
    private final ModelMapper modelMapper;

    @Override
    @ExecutionTime
    @OffensiveWord
    public void save(Product product) {
        var userId=((AwesomeUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId();
        var loggedInUser = new User();
        loggedInUser.setId(userId);
        product.setUser(loggedInUser);
        productRepo.save(product);
    }

    @Override
    @ExecutionTime

    public List<ProductDto> findAll() {
        var productList = (List<Product>) productRepo.findAll();
        return productList.stream().map(p -> modelMapper.map(p, ProductDto.class)).toList();
    }

    @Override
    @ExecutionTime
    public ProductDto findById(int id) {
        var product = productRepo.findById(id).get();
        return modelMapper.map(product, ProductDto.class);
    }

    @Override
    @ExecutionTime
    public void deleteById(int id) {
        productRepo.deleteById(id);

    }
    @ExecutionTime
    public List<ProductDto> findProductsMoreThanMinPrice(double minPrice) {
        return productRepo.findByPriceGreaterThan(minPrice)
                .stream().map(product -> modelMapper
                        .map(product, ProductDto.class)).toList();
    }
    @ExecutionTime
    public List<ProductDto> findByCategoryAnAndPriceLessThan(String cat, double maxPrice) {
        return productRepo.findByCategory_NameIgnoreCaseAndPriceLessThan(cat, maxPrice)
                .stream().map(product -> modelMapper.map(product,ProductDto.class)).toList();
    }
    @ExecutionTime
    @Override
    public List<ProductDto> findByNameContains(String keyword) {
        return productRepo.findByNameContainsIgnoreCase(keyword).stream()
                .map(product -> modelMapper.map(product,ProductDto.class)).toList();
    }
}

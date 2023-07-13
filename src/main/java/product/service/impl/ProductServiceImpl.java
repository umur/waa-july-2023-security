package product.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import product.annotation.ProfanityFilter;
import product.dto.product.CreateProductDto;
import product.dto.product.UpdateProductDto;
import product.entity.Product;
import product.entity.User;
import product.repository.ProductRepo;
import product.service.ProductService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;
    private final ModelMapper modelMapper;


    @Override
    public List<Product> findAll(){
        return productRepo.findAll();
    }

    @Override
    public List<Product> findAllByPriceGreaterThan(double minPrice){
        return productRepo.findAllByPriceGreaterThan(minPrice);
    }

    @Override
    public List<Product> findAllByCategoryId(Long categoryId){
        return productRepo.findAllByCategory_Id(categoryId);
    }

    @Override
    public List<Product> findAllByNameContaining(String keyword){
        return productRepo.findAllByNameContaining(keyword);
    }

    @Override
    public Product findById(Long id){
        return productRepo.findById(id).get();
    }

    @Override
    @ProfanityFilter
    public Product create(CreateProductDto productDto){
        Product product = modelMapper.map(productDto, Product.class);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        product.setUser(user);
        return productRepo.save(product);
    }

    @Override
    public Product update(UpdateProductDto productDto){
        Product product = findById(productDto.getId());
        modelMapper.map(productDto, product);
        return productRepo.save(product);
    }

    @Override
    public Product delete(Long id){
        Product product = findById(id);
        productRepo.delete(product);
        return product;
    }

}

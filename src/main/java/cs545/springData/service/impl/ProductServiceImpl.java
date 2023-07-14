package cs545.springData.service.impl;

import cs545.springData.entity.Category;
import cs545.springData.repository.ProductRepo;
import cs545.springData.entity.Product;
import cs545.springData.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;
    @Override
    public List<Product> getProduct(){
        return productRepo.findAll();
    }
    @Override
    public String addProduct(Product product ){
        productRepo.save(product);
        return "Product added";
    }
    @Override
    public Product updateProduct(Long id,Product product){
        Optional<Product> pro = productRepo.findById(id);
        if(pro.isPresent()){

            pro.get().setName(product.getName());
            pro.get().setPrice(product.getPrice());
            pro.get().setRating(product.getRating());
            pro.get().setCategory(product.getCategory());
            pro.get().setCategory(product.getCategory());
            pro.get().setReview(product.getReview());

            productRepo.save(pro.get());
        }
        return pro.get();

    }
    @Override
    public Product getById(Long id){
        Optional<Product> product= productRepo.findById(id);
        if(product.isPresent()) {
            return product.get();
        }else
            return null;
    }
    @Override
    public String DeleteById(Long id){
        Optional<Product> product= productRepo.findById(id);
        if(product.isPresent()){
            productRepo.deleteById(id);
        }
        return"Product deleted";
    }

public List<Product> findByCategoryAndPriceLessThan(Category category, Double maxPrice){
        return productRepo.findByCategoryAndPriceLessThan(category,maxPrice);
}
    public List<Product> findByNameContaining(String keyword){
        return productRepo.findByNameContaining(keyword);
    }
    public List<Product>  findByPriceGreaterThan(Double minPrice){
        return productRepo.findByPriceGreaterThan(minPrice);
    }
}

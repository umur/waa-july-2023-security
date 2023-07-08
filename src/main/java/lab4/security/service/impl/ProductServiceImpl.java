package lab4.security.service.impl;

import lab4.security.dto.requests.CreateProductDTO;
import lab4.security.entity.Category;
import lab4.security.entity.Product;
import lab4.security.exceptions.CustomError;
import lab4.security.exceptions.RecordNotFound;
import lab4.security.repository.CategoryRepo;
import lab4.security.repository.ProductRepo;
import lab4.security.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private ModelMapper modelMapper;


    public List<Product> getAll(){
        return this.productRepo.findAll();
    }
    public Optional<Product> findById(Long id){
       return  this.productRepo.findById(id);
    }

    public Product create(CreateProductDTO createProductDTO) throws RecordNotFound {
        Category category =  categoryRepo.findById(createProductDTO.getCategory_id()).orElseThrow(() -> new RecordNotFound("Could not find"));

        Product product = modelMapper.map(createProductDTO, Product.class);
        product.setCategory(category);

        return this.productRepo.save(product);
    }
    public Optional<Product>  update(Long id, Product updatedProduct){
        Optional<Product>  existingProduct = findById(id);
        if(existingProduct.isEmpty()){
            return existingProduct;
        }
        existingProduct.get().setName(updatedProduct.getName());
        existingProduct.get().setPrice(updatedProduct.getPrice());
        existingProduct.get().setRating(updatedProduct.getRating());
        existingProduct.get().setDescription(updatedProduct.getDescription());
        existingProduct.get().setCategory(updatedProduct.getCategory());

        return Optional.of(productRepo.save(existingProduct.get()));
    }

    public void deleteById(Long id){
        this.productRepo.deleteById(id);
    }

    @Override
    public List<Product> getByMinPrice(Double price) {
        return productRepo.findAllByPriceGreaterThan(price);
    }

    @Override
    public List<Product> getByCategoryAndMaxPrice(Long catId, Double price) {
        Optional<Category> category = categoryRepo.findById(catId);
        if (category.isEmpty())
            return Collections.emptyList();
        return productRepo.findAllByCategoryAndPriceLessThan(category.get(), price);
    }

    @Override
    public List<Product> getByKeyword(String keyword) {
        return productRepo.findAllByNameContaining(keyword);
    }
}

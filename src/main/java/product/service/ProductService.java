package product.service;

import product.dto.product.CreateProductDto;
import product.dto.product.UpdateProductDto;
import product.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    List<Product> findAllByPriceGreaterThan(double minPrice);

    List<Product> findAllByCategoryId(Long categoryId);

    List<Product> findAllByNameContaining(String keyword);

    Product findById(Long id);

    Product create(CreateProductDto productDto);

    Product update(UpdateProductDto productDto);

    Product delete(Long id);
}

package Demo1.demo.service;

import Demo1.demo.entity.Category;
import Demo1.demo.entity.Product;

import java.util.List;

public interface ProductService {

    void createProduct(Product product);

    void updateProduct(Product product, Long productId);

    void deleteProduct(Long productId);
    void getProductById(Long productId);
    List<Product> getAllProducts();


    List<Product> findAllByPriceGreaterThan(double minPrice);

    List<Product> findAllByCategoryAndPriceLessThan(Category category, double maxPrice);


    List<Product> findAllByNameContainingIgnoreCase(String keyword);
}

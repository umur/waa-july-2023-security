package cs545.Service;

import cs545.Domain.Category;
import cs545.Domain.Product;
import cs545.Domain.Review;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Integer id);
    Product createProduct(Product product);
    Product updateProduct(Integer id, Product product);
    void deleteProduct(Integer id);
    List<Product> getProductsGreaterThanMinPrice(Double minPrice);

    List<Product> getProductsByCategoryAndMaxPrice(String category, Double maxPrice);

    List<Product> getProductsByKeyword(String keyword);

    List<Review> getProductReviews(Integer id);
}

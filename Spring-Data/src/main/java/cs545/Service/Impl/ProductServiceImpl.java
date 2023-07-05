package cs545.Service.Impl;

import cs545.DAO.CategoryRepo;
import cs545.DAO.ProductRepo;
import cs545.DAO.ReviewRepo;
import cs545.Domain.Category;
import cs545.Domain.Product;
import cs545.Domain.Review;
import cs545.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepository;
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private ReviewRepo reviewRepo;

    @Autowired
    public ProductServiceImpl(ProductRepo productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Integer id, Product product) {
        Product existingProduct = productRepository.findById(id).get();
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setRating(product.getRating());
        return productRepository.save(existingProduct);
    }

    @Override
    public void deleteProduct(Integer id) {
        Product product = getProductById(id);
        productRepository.delete(product);
    }

    @Override
    public List<Product> getProductsGreaterThanMinPrice(Double minPrice) {
        return productRepository.findByPriceGreaterThan(minPrice);
    }

    @Override
    public List<Product> getProductsByCategoryAndMaxPrice(String categoryName, Double maxPrice) {
        Category category = categoryRepo.findByNameEquals(categoryName);
        return productRepository.findByCategoryAndPriceLessThan(category, maxPrice);
    }

    @Override
    public List<Product> getProductsByKeyword(String keyword) {
        return productRepository.findByNameContaining(keyword);
    }

    @Override
    public List<Review> getProductReviews(Integer id) {
        return reviewRepo.findByProduct_Id(id);
    }
}

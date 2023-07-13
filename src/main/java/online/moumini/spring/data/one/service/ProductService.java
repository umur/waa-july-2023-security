package online.moumini.spring.data.one.service;

import online.moumini.spring.data.one.model.Category;
import online.moumini.spring.data.one.model.Product;
import online.moumini.spring.data.one.repository.CategoryRepository;
import online.moumini.spring.data.one.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Iterable<Product> getAllProductsByPriceGreaterThan(double minPrice) {
        return productRepository.findAllByPriceGreaterThan(minPrice);
    }

    public Iterable<Product> getAllByPriceLessThanAndCategory(double maxPrice, Long category_id) {
        Optional<Category> category = categoryRepository.findById(category_id);
        return productRepository.findAllByPriceLessThanAndCategory(maxPrice, category.get());
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Pair<Boolean, Product> EditProduct(Product product) {
        boolean exists = productRepository.existsById(product.getId());
        productRepository.save(product);
        return Pair.of(exists, product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}

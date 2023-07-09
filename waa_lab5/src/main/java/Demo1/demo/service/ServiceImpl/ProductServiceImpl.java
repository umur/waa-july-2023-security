package Demo1.demo.service.ServiceImpl;

import Demo1.demo.entity.Category;
import Demo1.demo.entity.Product;
import Demo1.demo.repository.ProductRepository;
import Demo1.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
   ProductRepository productRepository;
    @Override
    public void createProduct(Product product) {
        productRepository.save(product);
    }
    @Override
    public void updateProduct(Product product, Long productId) {
        productRepository.findById(productId).map(product1 -> {
            product1.setName(product.getName());
            product1.setPrice(product.getPrice());
            return productRepository.save(product1);
        });
    }
    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
    @Override
    public void getProductById(Long productId) {
        productRepository.findById(productId);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

@Override
    public List<Product> findAllByPriceGreaterThan(double minPrice) {
        return productRepository.findAllByPriceGreaterThan(minPrice);
    }
    @Override
    public List<Product> findAllByCategoryAndPriceLessThan(Category category, double maxPrice) {
        return productRepository.findAllByCategoriesAndPriceLessThan(category, maxPrice);
    }
@Override
    public List<Product> findAllByNameContainingIgnoreCase(String keyword) {
        return productRepository.findByNameContainingIgnoreCase(keyword);
    }

}

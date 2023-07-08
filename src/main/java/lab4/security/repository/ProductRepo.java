package lab4.security.repository;

import lab4.security.entity.Category;
import lab4.security.entity.Product;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends ListCrudRepository<Product, Long> {
    List<Product> findAllByPriceGreaterThan(Double minPrice);
    List<Product> findAllByCategoryAndPriceLessThan(Category category, Double price);
    List<Product> findAllByNameContaining(String keyword);
}

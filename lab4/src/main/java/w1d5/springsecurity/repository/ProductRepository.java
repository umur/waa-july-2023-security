package w1d5.springsecurity.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import w1d5.springsecurity.entity.Category;
import w1d5.springsecurity.entity.Product;

import java.util.List;

@Repository
public interface ProductRepository extends ListCrudRepository<Product, Long> {
    List<Product> findByPriceGreaterThan(Double minPrice);

    List<Product> findAllByCategory(Category category);

    List<Product> findByCategoryAndPriceLessThan(Category category, Double maxPrice);

    List<Product> findByNameContaining(String keyword);
}

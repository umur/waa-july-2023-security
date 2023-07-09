package Demo1.demo.repository;

import Demo1.demo.entity.Category;
import Demo1.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

   List<Product> findAllByPriceGreaterThan(double minPrice);

   List<Product> findAllByCategoriesAndPriceLessThan(Category category, double maxPrice);

    List<Product> findByNameContainingIgnoreCase(String keyword);
}

package product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import product.entity.Product;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long> {

    List<Product> findAllByPriceGreaterThan(double minPrice);

    List<Product> findAllByCategory_Id(Long categoryId);

    List<Product> findAllByNameContaining(String name);

}

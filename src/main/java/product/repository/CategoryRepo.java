package product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import product.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Long> {
}

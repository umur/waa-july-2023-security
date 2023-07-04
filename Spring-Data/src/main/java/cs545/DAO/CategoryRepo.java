package cs545.DAO;

import cs545.Domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepo extends JpaRepository<Category,Integer> {
    Category findByNameEquals(String categoryName);
}

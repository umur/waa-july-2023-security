package cs545.DAO;

import cs545.Domain.Category;
import cs545.Domain.Product;
import cs545.Domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepo  extends JpaRepository<Product,Integer> {
    List<Product> findByPriceGreaterThan(Double minPrice);

    List<Product> findByCategoryAndPriceLessThan(Category category, Double maxPrice);

    List<Product> findByNameContaining(String keyword);


//    @Query("select r from Product p join p.reviews r where p.id=?1")
//    List<Review> findReviewByProductId(Integer id);
}

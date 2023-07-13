package product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import product.entity.Review;

import java.util.List;

public interface ReviewRepo extends JpaRepository<Review, Long> {

    List<Review> findAllByProduct_Id(Long productId);
}

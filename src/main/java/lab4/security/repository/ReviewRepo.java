package lab4.security.repository;

import lab4.security.entity.Product;
import lab4.security.entity.Review;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepo extends ListCrudRepository<Review, Long> {
    List<Review> findAllByProduct(Product product);
}

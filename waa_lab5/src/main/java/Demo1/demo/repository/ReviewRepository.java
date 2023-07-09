package Demo1.demo.repository;

import Demo1.demo.entity.Review;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends ListCrudRepository<Review, Long> {

    List<Review> findAllReviewsById(Long productId);


}

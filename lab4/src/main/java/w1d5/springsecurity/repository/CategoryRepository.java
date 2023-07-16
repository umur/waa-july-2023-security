package w1d5.springsecurity.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import w1d5.springsecurity.entity.Category;

@Repository
public interface CategoryRepository extends ListCrudRepository<Category, Long> {
}

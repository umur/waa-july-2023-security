package Demo1.demo.repository;

import Demo1.demo.entity.User;
import org.springframework.data.repository.ListCrudRepository;

public interface UserRepository extends ListCrudRepository<User, Long> {
    User findByEmail(String email);
}

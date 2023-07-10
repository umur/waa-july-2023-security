package w1d5.springsecurity.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import w1d5.springsecurity.entity.User;

@Repository
public interface UserRepository extends ListCrudRepository<User, Long> {
    User findByEmail(String email);
}

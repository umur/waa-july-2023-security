package cs545.DAO;

import cs545.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo  extends JpaRepository<User,Integer> {
   Optional<User> findByEmail(String email);
}

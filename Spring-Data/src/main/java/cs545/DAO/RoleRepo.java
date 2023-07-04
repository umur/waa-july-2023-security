package cs545.DAO;

import cs545.Domain.Role;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Order(1)
public interface RoleRepo extends JpaRepository<Role,Integer> {
    Role getByRole(String user);
}

package lab4.security.repository;

import lab4.security.entity.Role;
import org.springframework.data.repository.ListCrudRepository;

public interface RoleRepo extends ListCrudRepository<Role,Long> {
    Role findOneByName(String name);
}

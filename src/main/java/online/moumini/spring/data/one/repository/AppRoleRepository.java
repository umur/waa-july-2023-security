package online.moumini.spring.data.one.repository;

import online.moumini.spring.data.one.model.AppRole;
import org.springframework.data.repository.CrudRepository;

public interface AppRoleRepository extends CrudRepository<AppRole, Long>{
    AppRole findByRoleName(String roleName); 
}

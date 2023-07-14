package cs545.springData.repository;

import cs545.springData.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends ListCrudRepository<User,Long> {
    @Query("select u from User u where u.email=?1")
    User findUserByEmail(String email);
}

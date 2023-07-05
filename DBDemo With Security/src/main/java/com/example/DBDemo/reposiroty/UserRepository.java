package com.example.DBDemo.reposiroty;

import com.example.DBDemo.entity.User;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends ListCrudRepository<User, Long> {

    Optional<User> findByEmail(String email);

}

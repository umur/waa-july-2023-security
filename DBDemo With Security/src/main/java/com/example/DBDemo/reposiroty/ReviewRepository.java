package com.example.DBDemo.reposiroty;

import com.example.DBDemo.entity.Review;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends ListCrudRepository<Review, Long> {

}

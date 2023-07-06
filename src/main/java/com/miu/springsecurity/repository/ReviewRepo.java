package com.miu.springsecurity.repository;

import com.miu.springsecurity.entity.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepo extends CrudRepository<Review,Integer> {
    List<Review> findReviewByProduct_Id(int id);
}

package com.waa.lab3.repository;
import com.waa.lab3.entity.Category;
import com.waa.lab3.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends ListCrudRepository<Category,Long> {

}

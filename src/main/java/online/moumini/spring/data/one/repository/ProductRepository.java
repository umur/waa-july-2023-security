package online.moumini.spring.data.one.repository;

import online.moumini.spring.data.one.model.Category;
import online.moumini.spring.data.one.model.Product;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

    Iterable<Product> findAllByPriceGreaterThan(double minPrice);

    Iterable<Product> findAllByPriceLessThanAndCategory(double maxPrice, Category cat);

    Iterable<Product> findAllByNameContains(String keyword);

}

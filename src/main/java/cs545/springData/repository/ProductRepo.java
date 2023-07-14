package cs545.springData.repository;

import cs545.springData.entity.Category;
import cs545.springData.entity.Product;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  ProductRepo extends ListCrudRepository<Product,Long> {
//    @Query("select p from Product  p having p.price>min(p.price)")
//    public List<Product> findByPriceGreaterThan(Double minPrice);
//
//    @Query("select p from Product p where p.name like '%keyword %'")
//    public List<Product> findByNameContaining(String keyword);
//List<Product> findByCategoryAndPriceLessThan(Category category, double maxPrice);
    public List<Product>  findByPriceGreaterThan(Double minPrice);
    public List<Product> findByNameContaining(String keyword);
    public List<Product> findByCategoryAndPriceLessThan(Category category, Double maxPrice);


}

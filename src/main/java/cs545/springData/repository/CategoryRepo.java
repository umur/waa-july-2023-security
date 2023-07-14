package cs545.springData.repository;

import cs545.springData.entity.Category;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  CategoryRepo extends ListCrudRepository<Category,Long> {

//    @Query("select c.products from Category  c join c.products p having p.price<max(p.price) and c=?1")
//    public List<Product> findByCategoryAndPriceLessThan(Category cat);

}

package cs545.springData.service;

import cs545.springData.entity.Category;
import cs545.springData.entity.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getProduct();
    public String addProduct(Product product );
    public Product updateProduct(Long id,Product product);
    public Product  getById(Long id);
    public String DeleteById(Long id);

   public List<Product> findByNameContaining(String keyword);
    public List<Product>  findByPriceGreaterThan(Double minPrice);
    public List<Product> findByCategoryAndPriceLessThan(Category category, Double maxPrice);

}

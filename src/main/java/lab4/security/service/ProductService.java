package lab4.security.service;
import lab4.security.dto.requests.CreateProductDTO;
import lab4.security.entity.Product;
import lab4.security.exceptions.RecordNotFound;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {

    public List<Product> getAll();
    public Optional<Product> findById(Long id);
    public Product create(CreateProductDTO createProductDTO) throws RecordNotFound;
    public Optional<Product>  update(Long id, Product product);
    public void deleteById(Long id);

    List<Product> getByMinPrice(Double price);
    List<Product> getByCategoryAndMaxPrice(Long catId, Double price);
    List<Product> getByKeyword(String keyword);
}

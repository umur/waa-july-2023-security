package lab4.security.service;

import lab4.security.entity.Category;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface CategoryService {

    public List<Category> getAll();
    public Optional<Category> findById(Long id);
    public Category create(Category category);
    public Optional<Category>  update(Long id,Category category);
    public void deleteById(Long id);

}

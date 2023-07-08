package lab4.security.service;

import lab4.security.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    public List<User> getAll();
    public Optional<User> findById(Long id);
    public User create(User user);
    public Optional<User>  update(Long id, User user);
    public void deleteById(Long id);
}

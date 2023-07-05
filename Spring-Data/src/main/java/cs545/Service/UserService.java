package cs545.Service;

import cs545.Domain.User;

import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService  {
    List<User> getAllUsers();
    User getUserById(Integer id);
    User createUser(User user);
    User updateUser(Integer id, User user);
    void deleteUser(Integer id);

}

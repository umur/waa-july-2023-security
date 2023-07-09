package Demo1.demo.service;

import Demo1.demo.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService {

    void addUser(User user);

    void updateUser(User user, Long Id);
    void getUser(String email);

    void deleteUser(Long Id);
    abstract void getAllUsers();

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}

package Demo1.demo.service.ServiceImpl;

import Demo1.demo.entity.User;
import Demo1.demo.repository.UserRepository;
import Demo1.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
@Autowired
private UserRepository userRepository;
    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(User user, Long Id) {
        userRepository.findById(Id).map(user1 -> {
            user1.setFirstName(user1.getFirstName());
            user1.setEmail(user1.getEmail());
            return userRepository.save(user1);
        });
    }

    @Override
    public void getUser(String email) {
        userRepository.findByEmail(email);
    }

    @Override
    public void deleteUser(Long Id) {
        userRepository.deleteById(Id);
    }

    @Override
    public void getAllUsers() {
        userRepository.findAll();

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}

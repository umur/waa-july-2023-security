package online.moumini.spring.data.one.service;

import online.moumini.spring.data.one.model.AppUser;
import online.moumini.spring.data.one.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserService {

    @Autowired
    private AppUserRepository userRepository;

    public Iterable<AppUser> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<AppUser> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public AppUser saveUser(AppUser user) {
        
        return userRepository.save(user);
    }

    public Pair<Boolean, AppUser> EditUser(AppUser user) {
        boolean exists = userRepository.existsById(user.getId());
        userRepository.save(user);
        return Pair.of(exists, user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

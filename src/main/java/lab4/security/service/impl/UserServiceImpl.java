package lab4.security.service.impl;


import lab4.security.entity.User;
import lab4.security.repository.UserRepo;
import lab4.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    public List getAll(){
        return this.userRepo.findAll();
    }
    public Optional<User> findById(Long id){
        return this.userRepo.findById(id);
    }
    public User create(User user){

        return this.userRepo.save(user);
    }
    public Optional<User>  update(Long id, User updatedUser){

        Optional<User>  existingUser = findById(id);
        if(existingUser.isEmpty()){
            return existingUser;
        }
        existingUser.get().setEmail(updatedUser.getEmail());
        existingUser.get().setFirstName(updatedUser.getFirstName());
        existingUser.get().setLastName(updatedUser.getLastName());
        existingUser.get().setPassword(updatedUser.getPassword());
        existingUser.get().setAddress(updatedUser.getAddress());
        return Optional.of(userRepo.save(existingUser.get()));

    }
    public void deleteById(Long id){
        this.userRepo.deleteById(id);
    }
}

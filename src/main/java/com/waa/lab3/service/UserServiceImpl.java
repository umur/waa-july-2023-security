package com.waa.lab3.service;
import com.waa.lab3.entity.User;
import com.waa.lab3.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public String addUser(User user){
        userRepo.save(user);
        return "user added";
    }
    @Override
    public User getById(Long id){
        Optional<User> addr= userRepo.findById(id);
        if(addr.isPresent())return addr.get();
        else return null;
    }
    @Override
    public List<User> getAllBy(){
        return userRepo.findAll();
    }
    @Override
    public String updateUser(Long id, User use){
        Optional<User>us=userRepo.findById(id);
        if(us.isPresent()){
            User u=us.get();
            u.setAddress(use.getAddress());
            u.setEmail(use.getEmail());
            u.setFirstname(use.getFirstname());
            u.setLastname(use.getLastname());
            u.setPassword(use.getPassword());
            u.setReviewList(use.getReviewList());
            userRepo.save(u);
        }
        return "user updated";
    }
    @Override
    public String deleteUser(Long id){
        userRepo.deleteById(id);
        return "user deleted";
    }

    @Override
    public User getByEmail(String email) {
        return userRepo.findByEmail(email);
    }
}

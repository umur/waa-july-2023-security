package cs545.springData.service.impl;

import cs545.springData.entity.User;
import cs545.springData.repository.UserRepo;
import cs545.springData.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    public List<User> getUser(){

        return  userRepo.findAll();
    }
    public String addUser(User user ){
        userRepo.save(user);
        return "new User added";
    }
    public User updateUser(Long id,User user){
        Optional<User> u = userRepo.findById(id);
        if(u.isPresent()){

            u.get().setName(user.getName());
            u.get().setAmount(user.getAmount());
            u.get().setPassword(user.getPassword());
            u.get().setFirstName(user.getFirstName());
            u.get().setLastName(user.getLastName());
            u.get().setReview(user.getReview());
            u.get().setAddress(user.getAddress());


            userRepo.save(u.get());
        }
        return u.get();

    }
    public User  getById(Long id){
        Optional<User> user= userRepo.findById(id);
        if(user.isPresent()) {
            return user.get();
        }else
            return null;
    }
    public String DeleteById(Long id){
        Optional<User> user= userRepo.findById(id);
        if(user.isPresent()){
            userRepo.deleteById(id);
        }
        return"user deleted";
    }
    public User findUserByEmail(String email){
        return userRepo.findUserByEmail(email);

    }
}

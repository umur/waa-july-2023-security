package cs545.springData.service;

import cs545.springData.entity.User;

import java.util.List;

public interface UserService {
     List<User> getUser();
     String addUser(User user );
    User updateUser(Long id,User user);
     User  getById(Long id);
     String DeleteById(Long id);
    User findUserByEmail(String email);
}


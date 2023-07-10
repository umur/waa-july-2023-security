package w1d5.springsecurity.service;

import w1d5.springsecurity.entity.User;

import java.util.List;

public interface UserService {
    User create(User user);

    List<User> findAll();

    User findById(Long id);

    User update(Long id, User user);

    void delete(Long id);
}

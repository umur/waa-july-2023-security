package product.service;

import product.dto.user.CreateUserDto;
import product.dto.user.UpdateUserDto;
import product.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(Long id);

    User create(CreateUserDto userDto);

    User update(UpdateUserDto userDto);

    User delete(Long id);
}

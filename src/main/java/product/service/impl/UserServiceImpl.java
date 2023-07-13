package product.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import product.dto.user.CreateUserDto;
import product.dto.user.UpdateUserDto;
import product.entity.User;
import product.repository.UserRepo;
import product.service.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<User> findAll(){
        return userRepo.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepo.findById(id).get();
    }

    @Override
    public User create(CreateUserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        user.getAddress().setUser(null);
        return userRepo.save(user);
    }

    @Override
    public User update(UpdateUserDto userDto) {
        User user = findById(userDto.getId());
        modelMapper.map(userDto, user);
        return userRepo.save(user);
    }

    @Override
    public User delete(Long id) {
        User user = findById(id);
        userRepo.delete(user);
        return user;
    }


}

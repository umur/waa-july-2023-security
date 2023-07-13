package product.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import product.dto.user.CreateUserDto;
import product.dto.user.UpdateUserDto;
import product.entity.User;
import product.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("{id}")
    public User findById(@PathVariable Long id){
        return userService.findById(id);
    }

    //@PostMapping
    private User create(@RequestBody CreateUserDto userDto){
        return userService.create(userDto);
    }

    @PutMapping("{id}")
    private User update(@PathVariable Long id, @RequestBody UpdateUserDto userDto){
        userDto.setId(id);
        return userService.update(userDto);
    }

    @DeleteMapping("{id}")
    private User delete(@PathVariable Long id){
        return userService.delete(id);
    }

}

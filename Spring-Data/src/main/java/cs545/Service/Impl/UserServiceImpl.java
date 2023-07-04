package cs545.Service.Impl;

import cs545.DAO.RoleRepo;
import cs545.DAO.UserRepo;
import cs545.Domain.User;

import cs545.Service.UserService;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {


    public BCryptPasswordEncoder pwdEncoder;
    private final UserRepo userRepository;
    private final RoleRepo roleRepo;

    public UserServiceImpl(UserRepo userRepository, BCryptPasswordEncoder pwdEncoder, RoleRepo roleRepo) {
        this.pwdEncoder=pwdEncoder;
        this.userRepository = userRepository;
        this.roleRepo = roleRepo;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id).get();
    }

    public User createUser(User user) {

        if(user.getRoles().isEmpty()){
            user.addRole(roleRepo.getByRole("USER"));
        }
        user.setPassword(pwdEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Integer id, User user) {

        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(pwdEncoder.encode(user.getPassword()));
            return userRepository.save(existingUser);
        }
        return null;
    }

    @Override
    public void deleteUser(Integer id) {
        User user = getUserById(id);
        userRepository.delete(user);
    }
    public Optional<User>  findUserByEmail(String userName){
        return userRepository.findByEmail(userName);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> opt = findUserByEmail(email);
        User user= opt.get();
        if(opt.isEmpty()){
            throw new UsernameNotFoundException(" user doesn't exist");}
        UserDetails userDetails= new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                user.getRoles().stream().
                        map(role -> new SimpleGrantedAuthority(role.getRole())).
                        collect(Collectors.toList()));

        CustomUserDetails customUserDetails = new CustomUserDetails(userDetails);
        customUserDetails.setId(user.getId());

        return customUserDetails;


    }

}

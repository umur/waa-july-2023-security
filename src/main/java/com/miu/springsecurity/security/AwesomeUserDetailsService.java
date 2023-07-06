package com.miu.springsecurity.security;

import com.miu.springsecurity.entity.User;
import com.miu.springsecurity.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("userDetailsService")
@Transactional
@RequiredArgsConstructor
public class AwesomeUserDetailsService implements UserDetailsService {
private final UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user=userRepo.findByEmail(username);
    var userDetails=new AwesomeUserDetails(user);
    return userDetails;
    }
}

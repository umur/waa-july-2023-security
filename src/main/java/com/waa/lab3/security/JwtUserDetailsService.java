package com.waa.lab3.security;

import com.waa.lab3.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
@Transactional
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        final com.waa.lab3.entity.User customer = userRepository.findByEmail(email);
        if (customer == null) {
            throw new UsernameNotFoundException("Email not found with email address: " + email);
        }
        UserDetails user = User.withUsername(customer.getEmail())
                .password(customer.getPassword()).build();
        return user;
    }
}

package com.miu.waa.lab3.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miu.waa.lab3.entity.User;
import com.miu.waa.lab3.entity.dto.MyUserDetails;

import lombok.RequiredArgsConstructor;

@Service("userDetailsService")
@Transactional
@RequiredArgsConstructor
public class MyUserDetailService implements UserDetailsService {
    private final UserServiceImpl userServiceImpl;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userServiceImpl.findByEmail(username);
        return new MyUserDetails(user);
    }

}

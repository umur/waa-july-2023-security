package com.miu.waa.lab3.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.miu.waa.lab3.entity.User;
import com.miu.waa.lab3.entity.dto.MyUserDetails;

@Component
public class SecurityUtil {
    public User getCurrentUser() {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        return userDetails.getUser();
    }
}

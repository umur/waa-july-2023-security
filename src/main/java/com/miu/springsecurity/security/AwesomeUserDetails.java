package com.miu.springsecurity.security;

import com.miu.springsecurity.entity.Role;
import com.miu.springsecurity.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class AwesomeUserDetails implements UserDetails {
    private String email;
    private String password;
    private int userId;
    private List<Role> roles;



    public AwesomeUserDetails(User user) {
        this.userId=user.getId();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.roles = user.getRoles();
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        var result= roles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_"+role.getRole().toUpperCase(Locale.ROOT)))
                .collect(Collectors.toList());
        return result;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email
                ;
    }
    public int getUserId() {
        return userId;

    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

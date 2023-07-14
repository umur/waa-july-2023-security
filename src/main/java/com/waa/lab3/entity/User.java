package com.waa.lab3.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    @OneToOne
    private Address address;
    @OneToMany(mappedBy="user")
    private List<Review> reviewList;
    public UserDetails toSpringUser() {
        return org.springframework.security.core.userdetails.User.builder()
                .username(email)
                .password(password)
                .roles("ROLE_USER")
                .build();
    }
}

package com.waa.lab3.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String street;
    private  String zip;
    private String city;
    @OneToOne(mappedBy = "address")
    private User user;

}

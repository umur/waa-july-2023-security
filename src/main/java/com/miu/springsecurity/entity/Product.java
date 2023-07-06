package com.miu.springsecurity.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


import java.util.List;


@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;
    private int rating;
    @OneToMany(mappedBy = "product")
    //@JsonBackReference
    List<Review> reviews;
    @ManyToOne
    //@JsonManagedReference
     private Category category;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

package cs545.springData.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Double amount;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
//    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<Review> review;
//    @JsonManagedReference
    @OneToOne
    private Address address;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable
    private List<Role> roles;

}

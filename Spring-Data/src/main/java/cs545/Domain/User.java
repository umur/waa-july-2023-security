package cs545.Domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String email;

    private String firstName;
    private String lastName;

    private String password;

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @JsonBackReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Review> reviews;

    @JsonManagedReference
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable
    private List<Role> roles;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Product> product;

    public void addRole(Role role){
        roles.add(role);
    }










}

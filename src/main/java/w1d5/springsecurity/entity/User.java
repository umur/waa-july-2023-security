package w1d5.springsecurity.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String email, password, firstName, lastname;

    @JsonManagedReference
    @OneToOne
    private Address address;

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<Review> reviews;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Role> roles;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && email.equals(user.email) && password.equals(user.password) && firstName.equals(user.firstName) && lastname.equals(user.lastname) && address.equals(user.address) && reviews.equals(user.reviews);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, firstName, lastname, address, reviews);
    }
}

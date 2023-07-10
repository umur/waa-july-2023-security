package w1d5.springsecurity.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String street, zip, city;

    @JsonBackReference
    @OneToOne
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return id == address.id && street.equals(address.street) && zip.equals(address.zip) && city.equals(address.city) && user.equals(address.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, street, zip, city, user);
    }
}

package cs545.Domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String street;

    private Integer zip;

    private String city;

    @JsonBackReference
    @OneToOne(mappedBy = "address")
    private User user;



}

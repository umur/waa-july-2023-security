package cs545.springData.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String Street;
    private String zip;
    private String city;
    @OneToOne(mappedBy = "address")
    private User user;

}

package Demo1.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@Table(name="address")
public class Address {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private  Long AddressId;
    private String street;
    private String zip;
       private String city;

}

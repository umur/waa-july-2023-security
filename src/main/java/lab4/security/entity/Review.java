package lab4.security.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue()
    private Long id;
    private String comment;
    private float rating;

    @ManyToOne
    @JoinColumn
    @JsonBackReference
    private Product product;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn
    private User user;
}

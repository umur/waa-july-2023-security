package cs545.Domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String comment;

    @JsonManagedReference
    @ManyToOne
    private Product product;

    @JsonManagedReference
    @ManyToOne
    private User user;

}

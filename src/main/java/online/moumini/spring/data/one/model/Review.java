package online.moumini.spring.data.one.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review implements Serializable {

    @EmbeddedId
    private ReviewId reviewId;

    private String comment;
}
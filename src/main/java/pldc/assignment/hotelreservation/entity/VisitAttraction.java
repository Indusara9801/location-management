package pldc.assignment.hotelreservation.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "visit_attraction")
@Data
@NoArgsConstructor
public class VisitAttraction {
    @PrePersist
    public void prePersist(){
        rating = 3.0;
    }

    @Id
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "visit_id")
    @JsonBackReference
    private Visit visit;

    @ManyToOne
    @JoinColumn(name = "attraction_id")
    private Attraction attraction;

    @Column(name = "rating")
    private Double rating;


}

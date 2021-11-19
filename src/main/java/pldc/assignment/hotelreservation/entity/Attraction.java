package pldc.assignment.hotelreservation.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "attraction")
@Data
@NoArgsConstructor
public class Attraction {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "historical")
    private Boolean historical;

    @Column(name = "religious")
    private Boolean religious;

    @Column(name = "beaches")
    private Boolean beaches;

    @Column(name = "animal_sanc")
    private Boolean animalSanc;

    @Column(name = "hiking")
    private Boolean hiking;

    @Column(name = "forest")
    private Boolean forest;

    @Column(name = "parks")
    private Boolean parks;

    @Column(name = "lakes")
    private Boolean lakes;

    @ManyToOne
    @JoinColumn(name = "district_id")
    @JsonBackReference
    private District district;

    @OneToMany(mappedBy = "attraction")
    @JsonIgnore
    private List<VisitAttraction> visitAttractions;


}

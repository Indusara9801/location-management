package pldc.assignment.hotelreservation.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
@Table(name = "district")
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "country")
    private String country;

    @Column(name = "name")
    private String name;

    @Column(name = "image_name")
    private String imageName;

    @OneToMany(mappedBy = "district")
    @JsonManagedReference
    private List<Attraction> attractions;
}

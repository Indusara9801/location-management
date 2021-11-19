package pldc.assignment.hotelreservation.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String password;
    private String username;
    private String country;


    @ManyToOne
    @JoinColumn(name = "district_id")
    private District district;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();

    @OneToMany(mappedBy = "hotel")
    @JsonManagedReference
    private List<Room> rooms;

}

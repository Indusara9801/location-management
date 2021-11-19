package pldc.assignment.hotelreservation.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pldc.assignment.hotelreservation.entity.Attraction;
import pldc.assignment.hotelreservation.entity.District;

import java.util.List;

public interface AttractionRepository extends JpaRepository<Attraction, Integer> {
    public List<Attraction> findAttractionsByDistrict(District district);
}

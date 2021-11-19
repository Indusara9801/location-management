package pldc.assignment.hotelreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pldc.assignment.hotelreservation.entity.District;

public interface DistrictRepository extends JpaRepository<District, Integer> {
}

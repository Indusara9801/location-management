package pldc.assignment.hotelreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pldc.assignment.hotelreservation.entity.Attraction;
import pldc.assignment.hotelreservation.entity.VisitAttraction;

import java.util.List;

public interface VisitAttractionRepository extends JpaRepository<VisitAttraction, Integer> {
    public List<VisitAttraction> findAllByAttraction(Attraction attraction);
}

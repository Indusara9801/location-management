package pldc.assignment.hotelreservation.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pldc.assignment.hotelreservation.entity.User;
import pldc.assignment.hotelreservation.entity.Visit;

import java.util.Date;
import java.util.List;

public interface VisitRepository extends JpaRepository<Visit, Integer> {
    public List<Visit> findVisitsByUserOrderByDate(User user);
    public List<Visit> findVisitsByDate(Date visitDate);
}

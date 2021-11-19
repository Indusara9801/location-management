package pldc.assignment.hotelreservation.service;



import pldc.assignment.hotelreservation.entity.VisitAttraction;

import java.util.List;

public interface VisitAttractionService {
    public List<VisitAttraction> getVisitAttractions();
    public List<VisitAttraction> getVisitAttractionsByAttraction(int attractionId);
    public double getAverageRatingByAttraction(int attractionId);
}

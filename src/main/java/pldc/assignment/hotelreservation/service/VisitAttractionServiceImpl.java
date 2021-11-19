package pldc.assignment.hotelreservation.service;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pldc.assignment.hotelreservation.entity.Attraction;
import pldc.assignment.hotelreservation.entity.VisitAttraction;
import pldc.assignment.hotelreservation.repository.VisitAttractionRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VisitAttractionServiceImpl implements VisitAttractionService {
    private final VisitAttractionRepository visitAttractionRepository;
    private final AttractionService attractionService;



    @Override
    public List<VisitAttraction> getVisitAttractions() {
        return visitAttractionRepository.findAll();
    }

    @Override
    public List<VisitAttraction> getVisitAttractionsByAttraction(int attractionId) {
        Attraction attraction = attractionService.getAttraction(attractionId);
        return visitAttractionRepository.findAllByAttraction(attraction);
    }

    @Override
    public double getAverageRatingByAttraction(int attractionId) {
        List<VisitAttraction> visitAttractionList = getVisitAttractionsByAttraction(attractionId);
        double totalRating = 0;
        for(VisitAttraction visitAttraction: visitAttractionList){
            totalRating = totalRating + visitAttraction.getRating();
        }
        return totalRating/visitAttractionList.size();
    }
}

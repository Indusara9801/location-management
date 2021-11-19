package pldc.assignment.hotelreservation.rest;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pldc.assignment.hotelreservation.entity.VisitAttraction;
import pldc.assignment.hotelreservation.service.VisitAttractionService;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class VisitAttractionRestController {
    private final VisitAttractionService visitAttractionService;

    @GetMapping("/visitAttractions")
    public List<VisitAttraction> getVisitAttractions(){
        return visitAttractionService.getVisitAttractions();
    }

    @GetMapping("/visitAttractionsByAttraction/{attraction_id}")
    public List<VisitAttraction> getVisitAttractionsByAttraction(@PathVariable("attraction_id") int id){
        return visitAttractionService.getVisitAttractionsByAttraction(id);
    }

    @GetMapping("/averageRatingByAttraction/{attraction_id}")
    public double getAverageRatingByAttraction(@PathVariable("attraction_id") int id){
        return visitAttractionService.getAverageRatingByAttraction(id);
    }
}

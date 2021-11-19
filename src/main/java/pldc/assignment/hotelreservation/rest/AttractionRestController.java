package pldc.assignment.hotelreservation.rest;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pldc.assignment.hotelreservation.entity.Attraction;
import pldc.assignment.hotelreservation.service.AttractionService;

import java.util.List;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AttractionRestController {
    private final AttractionService attractionService;

    @GetMapping("/attractions")
    public List<Attraction> getAttractions(){
        return attractionService.getAttractions();
    }

    @GetMapping("/attractions/{attraction_id}")
    public Attraction getAttraction(@PathVariable("attraction_id") int id){
        Attraction attraction = attractionService.getAttraction(id);
        if (attraction == null){
            throw new RuntimeException("Attraction is not found");
        }
        return attraction;
    }

    @GetMapping("/attractionsByDistrict/{district_id}")
    public List<Attraction> getAttractionsByBungalow(@PathVariable("district_id") int id){
        return attractionService.getAttractionsByDistrict(id);
    }



}

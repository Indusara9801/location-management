package pldc.assignment.hotelreservation.service;



import pldc.assignment.hotelreservation.entity.Attraction;

import java.util.List;

public interface AttractionService {
    public Attraction getAttraction(int id);
    public List<Attraction> getAttractions();
    public List<Attraction> getAttractionsByDistrict(int districtId);

}

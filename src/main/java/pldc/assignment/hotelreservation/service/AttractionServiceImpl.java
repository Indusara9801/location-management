package pldc.assignment.hotelreservation.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pldc.assignment.hotelreservation.entity.Attraction;
import pldc.assignment.hotelreservation.entity.District;
import pldc.assignment.hotelreservation.repository.AttractionRepository;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AttractionServiceImpl implements AttractionService{
    private final AttractionRepository attractionRepository;
    private final DistrictService districtService;




    @Override
    public Attraction getAttraction(int id) {
        Optional<Attraction> result = attractionRepository.findById(id);
        Attraction obj = null;
        if (result.isPresent()){
            obj = result.get();
        }
        return obj;
    }

    @Override
    public List<Attraction> getAttractions() {
        return attractionRepository.findAll();
    }

    @Override
    public List<Attraction> getAttractionsByDistrict(int districtId) {
        District district = districtService.getDistrict(districtId);
        return attractionRepository.findAttractionsByDistrict(district);
    }


}

package pldc.assignment.hotelreservation.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pldc.assignment.hotelreservation.entity.District;
import pldc.assignment.hotelreservation.service.DistrictService;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class DistrictRestController {
    private final DistrictService districtService;

    @GetMapping("/districts/{district_id}")
    public District getDistrict(@PathVariable("district_id") int id){
        return districtService.getDistrict(id);
    }

    @GetMapping("/districts")
    public List<District> getDistricts(){
        return districtService.getDistricts();
    }
}

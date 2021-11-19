package pldc.assignment.hotelreservation.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pldc.assignment.hotelreservation.entity.District;
import pldc.assignment.hotelreservation.repository.DistrictRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DistrictServiceImpl implements DistrictService{
    private final DistrictRepository districtRepository;

    @Override
    public District getDistrict(int districtId) {
        Optional<District> result = districtRepository.findById(districtId);
        District district = null;
        if(result.isPresent()){
            district = result.get();
        }
        return district;
    }

    @Override
    public List<District> getDistricts() {
        return districtRepository.findAll();
    }
}

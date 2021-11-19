package pldc.assignment.hotelreservation.service;

import pldc.assignment.hotelreservation.entity.District;

import java.util.List;

public interface DistrictService {
    public District getDistrict(int districtId);
    public List<District> getDistricts();
}

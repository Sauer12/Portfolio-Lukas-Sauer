package sk.tsystems.lzm.service;

import sk.tsystems.lzm.entity.DistrictHospitalBeds;

import java.util.List;

public interface DistrictHospitalBedsService {

    void addDistrictHospitalBeds(DistrictHospitalBeds districtHospitalBeds);
    List<DistrictHospitalBeds> getAllDistrictHospitalBeds();
    void reset();
}

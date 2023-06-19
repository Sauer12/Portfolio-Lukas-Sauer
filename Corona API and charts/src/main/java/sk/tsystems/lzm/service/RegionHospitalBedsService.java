package sk.tsystems.lzm.service;

import sk.tsystems.lzm.entity.RegionHospitalBeds;

import java.util.List;

public interface RegionHospitalBedsService {

    void addRegionHospitalBeds(RegionHospitalBeds regionHospitalBeds);
    List<RegionHospitalBeds> getAllRegionHospitalBeds();
    void reset();
}

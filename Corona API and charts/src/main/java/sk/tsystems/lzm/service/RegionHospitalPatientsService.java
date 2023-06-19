package sk.tsystems.lzm.service;

import sk.tsystems.lzm.entity.RegionHospitalPatients;

import java.util.List;

public interface RegionHospitalPatientsService {

    void addRegionHospitalPatients(RegionHospitalPatients regionHospitalPatients);

    List<RegionHospitalPatients> getRegionHospitalPatients();

    void reset();
}

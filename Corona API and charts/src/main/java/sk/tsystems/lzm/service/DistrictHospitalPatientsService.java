package sk.tsystems.lzm.service;

import sk.tsystems.lzm.entity.DistrictHospitalPatients;

import java.util.List;

public interface DistrictHospitalPatientsService {

    void addDistrictHospitalPatients(DistrictHospitalPatients districtHospitalPatients);
    List<DistrictHospitalPatients> getAllDistrictHospitalPatients();
    void reset();
}

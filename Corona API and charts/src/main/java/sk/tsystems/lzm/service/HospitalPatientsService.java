package sk.tsystems.lzm.service;

import sk.tsystems.lzm.entity.HospitalPatients;

import java.util.List;

public interface HospitalPatientsService {

    void addHospitalPatients(HospitalPatients hospitalPatients);
    List<HospitalPatients> getAllHospitalPatients();
    void reset();

}

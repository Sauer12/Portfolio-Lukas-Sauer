package sk.tsystems.lzm.service;

import sk.tsystems.lzm.entity.Hospital;

import java.util.List;

public interface HospitalService {

    void addHospital(Hospital hospital);
    List<Hospital> getHospitals();

    Hospital getHospital(int id);
    void reset();
}

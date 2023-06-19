package sk.tsystems.lzm.service;

import sk.tsystems.lzm.entity.HospitalBeds;

import java.util.List;

public interface HospitalBedsService {

    void addHospitalBeds(HospitalBeds hospitalBeds);
    List<HospitalBeds> getAllHospitalBeds();
    void reset();
}

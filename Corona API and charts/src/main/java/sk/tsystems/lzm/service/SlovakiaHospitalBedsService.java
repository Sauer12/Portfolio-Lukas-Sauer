package sk.tsystems.lzm.service;

import sk.tsystems.lzm.entity.SlovakiaHospitalBeds;

import java.util.List;

public interface SlovakiaHospitalBedsService {

    void addSlovakiaHospitalBeds(SlovakiaHospitalBeds slovakiaHospitalBeds);
    List<SlovakiaHospitalBeds> getAllSlovakiaHospitalBeds();

    Long getLastId();
    void reset();
}

package sk.tsystems.lzm.service;

import sk.tsystems.lzm.entity.City;
import sk.tsystems.lzm.entity.DistrictAgTests;

import java.util.List;

public interface DistrictAgTestsService {

    void addDistrictAgTests(DistrictAgTests districtAgTests);
    List<DistrictAgTests> getDistrictAgTestsAll();
    void reset();
}

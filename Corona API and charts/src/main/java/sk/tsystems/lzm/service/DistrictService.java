package sk.tsystems.lzm.service;

import sk.tsystems.lzm.entity.City;
import sk.tsystems.lzm.entity.District;

import java.util.List;

public interface DistrictService {

    void addDistrict(District district);
    List<District> getDistricts();
    void reset();
}

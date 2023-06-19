package sk.tsystems.lzm.service;

import sk.tsystems.lzm.entity.RegionVaccinations;

import java.util.List;

public interface RegionVaccinationsService {

    void addRegionVaccinations(RegionVaccinations regionVaccinations);

    List<RegionVaccinations> getRegionVaccinations();

    void reset();
}

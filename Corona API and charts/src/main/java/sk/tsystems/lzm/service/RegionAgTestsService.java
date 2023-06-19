package sk.tsystems.lzm.service;

import sk.tsystems.lzm.entity.RegionAgTests;

import java.util.List;

public interface RegionAgTestsService {

    void addRegionAgTests(RegionAgTests regionAgTests);
    List<RegionAgTests> getRegionAgTestsAll();
    void reset();
}

package sk.tsystems.lzm.service;

import sk.tsystems.lzm.entity.City;
import sk.tsystems.lzm.entity.Region;

import java.util.List;

public interface RegionService {

    void addRegion(Region region);
    List<Region> getRegions();
    void reset();
}

package sk.tsystems.lzm.service;

import sk.tsystems.lzm.entity.City;

import java.util.List;

public interface CityService {

    void addCity(City city);
    List<City> getCities();
    void reset();
}

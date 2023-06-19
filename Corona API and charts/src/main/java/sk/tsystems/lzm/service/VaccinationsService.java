package sk.tsystems.lzm.service;

import sk.tsystems.lzm.entity.Vaccinations;

import java.util.List;

public interface VaccinationsService {
    void addVaccinations(Vaccinations vaccinations);

    List<Vaccinations> getVaccinations();

    Vaccinations getVaccination(int id);

    void reset();
}

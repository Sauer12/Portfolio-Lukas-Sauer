package sk.tsystems.lzm.service;

import sk.tsystems.lzm.entity.Vaccine;

import java.util.List;

public interface VaccineService {

    void addVaccine(Vaccine vaccine);
    List<Vaccine> getAllVaccine();

    Vaccine getVaccine(int id);
    void reset();
}

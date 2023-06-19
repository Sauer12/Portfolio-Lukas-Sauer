package sk.tsystems.lzm.service;

import sk.tsystems.lzm.entity.SlovakiaVaccinations;

import java.util.List;

public interface SlovakiaVaccinationsService {

    void addSlovakiaVaccinations(SlovakiaVaccinations slovakiaVaccinations);

    List<SlovakiaVaccinations> getSlovakiaVaccinations();

    String getLastId();
    void reset();
}

package sk.tsystems.lzm.service;

import sk.tsystems.lzm.entity.City;
import sk.tsystems.lzm.entity.SlovakiaAgTests;

import java.util.List;

public interface SlovakiaAgTestsService {

    void addSlovakiaAgTests(SlovakiaAgTests slovakiaAgTests);
    List<SlovakiaAgTests> getSlovakiaAgTestsAll();

    String getLastId();
    void reset();
}

package sk.tsystems.lzm.service;

import sk.tsystems.lzm.entity.SlovakiaHospitalPatients;

import java.util.List;

public interface SlovakiaHospitalPatientsService {

    void addSlovakiaHospitalPatients(SlovakiaHospitalPatients slovakiaHospitalPatients);

    List<SlovakiaHospitalPatientsService> getSlovakiaHospitalPatients();

    void reset();
}

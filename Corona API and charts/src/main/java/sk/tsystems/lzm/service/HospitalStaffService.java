package sk.tsystems.lzm.service;

import sk.tsystems.lzm.entity.HospitalStaff;

import java.util.List;

public interface HospitalStaffService {

    void addHospitalStaff(HospitalStaff hospitalStaff);

    List<HospitalStaff> getHospitalStaff();

    void reset();
}

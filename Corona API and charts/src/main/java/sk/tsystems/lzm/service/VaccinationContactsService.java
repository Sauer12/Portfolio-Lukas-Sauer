package sk.tsystems.lzm.service;

import sk.tsystems.lzm.entity.VaccinationContacts;

import java.util.List;

public interface VaccinationContactsService {

    void addVaccinationsContacts(VaccinationContacts vaccinationContacts);

    List<VaccinationContacts> getVaccinationsContacts();

    void reset();
}

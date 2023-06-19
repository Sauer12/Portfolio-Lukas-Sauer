package sk.tsystems.lzm.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tsystems.lzm.entity.VaccinationContacts;
import sk.tsystems.lzm.service.VaccinationContactsService;
import sk.tsystems.lzm.service.VaccinationsService;

import java.util.List;

@RestController
@RequestMapping("/api/vaccinationcontacts")
public class VaccinationContactsWebServiceREST {

    @Autowired
    private VaccinationContactsService vaccinationContactsService;

    @PostMapping
    void addVaccinationContacts(@RequestBody VaccinationContacts vaccinationContacts){
        vaccinationContactsService.addVaccinationsContacts(vaccinationContacts);
    }

    @GetMapping
    List<VaccinationContacts> getVaccinationContacts(){
        return vaccinationContactsService.getVaccinationsContacts();
    }
}

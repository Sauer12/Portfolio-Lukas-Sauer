package sk.tsystems.lzm.server.webservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tsystems.lzm.entity.Vaccinations;
import sk.tsystems.lzm.service.VaccinationContactsService;
import sk.tsystems.lzm.service.VaccinationsService;

import java.util.List;

@RestController
@RequestMapping("api/vaccinations")
public class VaccinationsWebServiceREST {

    @Autowired
    private VaccinationsService vaccinationsService;

    @PostMapping
    void addVaccinations(@RequestBody Vaccinations vaccinations){
        vaccinationsService.addVaccinations(vaccinations);
    }

    @GetMapping
    List<Vaccinations> getVaccinations(){
        return vaccinationsService.getVaccinations();
    }
}

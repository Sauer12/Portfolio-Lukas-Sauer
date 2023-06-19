package sk.tsystems.lzm.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tsystems.lzm.entity.Vaccine;
import sk.tsystems.lzm.service.VaccineService;

import java.util.List;

@RestController
@RequestMapping("/api/vaccine")
public class VaccineWebServiceRest {

    @Autowired
    private VaccineService vaccineService;

    @PostMapping
    void addVaccine(@RequestBody Vaccine vaccine){
        vaccineService.addVaccine(vaccine);
    }

    @GetMapping
    public List<Vaccine> getAllVaccine(){
        return vaccineService.getAllVaccine();
    }
}

package sk.tsystems.lzm.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tsystems.lzm.entity.SlovakiaVaccinations;
import sk.tsystems.lzm.service.SlovakiaVaccinationsService;

import java.util.List;

@RestController
@RequestMapping("/api/slovakiavaccinations")
public class SlovakiaVaccinationsWebServiceREST {

    @Autowired
    private SlovakiaVaccinationsService slovakiaVaccinationsService;

    @PostMapping
    void addSlovakiaVaccinations(@RequestBody SlovakiaVaccinations slovakiaVaccinations){
        slovakiaVaccinationsService.addSlovakiaVaccinations(slovakiaVaccinations);
    }

    @GetMapping
    List<SlovakiaVaccinations> getSlovakiaVaccinations(){
       return slovakiaVaccinationsService.getSlovakiaVaccinations();
    }
}

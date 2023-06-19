package sk.tsystems.lzm.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tsystems.lzm.entity.RegionVaccinations;
import sk.tsystems.lzm.service.RegionVaccinationsService;

import java.util.List;

@RestController
@RequestMapping("/api/regionvaccinations")
public class RegionVaccinationsWebServiceREST {

    @Autowired
    private RegionVaccinationsService regionVaccinationsService;

    @PostMapping
    void addRegionVaccinations(@RequestBody RegionVaccinations regionVaccinations){
        regionVaccinationsService.addRegionVaccinations(regionVaccinations);
    }

    @GetMapping
    List<RegionVaccinations> getRegionVaccinations(){
        return regionVaccinationsService.getRegionVaccinations();
    }
}

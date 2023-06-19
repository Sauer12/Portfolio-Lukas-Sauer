package sk.tsystems.lzm.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tsystems.lzm.entity.RegionHospitalPatients;
import sk.tsystems.lzm.service.RegionHospitalPatientsService;

import java.util.List;

@RestController
@RequestMapping("/api/regionhospitalpatients")
public class RegionHospitalPatientsWebServiceREST {

    @Autowired
    private RegionHospitalPatientsService regionHospitalPatientsService;

    @PostMapping
    void addRegionHospitalPatients(@RequestBody RegionHospitalPatients regionHospitalPatients){
        regionHospitalPatientsService.addRegionHospitalPatients(regionHospitalPatients);
    }

    @GetMapping
    List<RegionHospitalPatients> getRegionHospitalPatients(){
        return regionHospitalPatientsService.getRegionHospitalPatients();
    }
}

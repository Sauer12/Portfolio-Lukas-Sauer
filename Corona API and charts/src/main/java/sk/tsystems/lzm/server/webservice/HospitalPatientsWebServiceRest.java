package sk.tsystems.lzm.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tsystems.lzm.entity.HospitalPatients;
import sk.tsystems.lzm.service.HospitalPatientsService;

import java.util.List;

@RestController
@RequestMapping("/api/HospitalPatients")
public class HospitalPatientsWebServiceRest {
    @Autowired
    private HospitalPatientsService hospitalPatientsService;

    @PostMapping
    void addHospitalPatients(@RequestBody HospitalPatients hospitalPatients){
        hospitalPatientsService.addHospitalPatients(hospitalPatients);
    }

    @GetMapping
    public List<HospitalPatients> getAllHospitalPatients(){
        return hospitalPatientsService.getAllHospitalPatients();
    }
}

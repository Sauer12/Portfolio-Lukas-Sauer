package sk.tsystems.lzm.server.webservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tsystems.lzm.entity.SlovakiaHospitalPatients;
import sk.tsystems.lzm.service.SlovakiaHospitalPatientsService;

import java.util.List;

@RestController
@RequestMapping("/api/slovakiahospitalpatients")
public class SlovakiaHospitalPatientsWebServiceREST {
    @Autowired
    private SlovakiaHospitalPatientsService slovakiaHospitalPatientsService;

    @PostMapping
    void addSlovakiaHospitalPatients(@RequestBody SlovakiaHospitalPatients slovakiaHospitalPatients){
        slovakiaHospitalPatientsService.addSlovakiaHospitalPatients(slovakiaHospitalPatients);
    }

    @GetMapping
    List<SlovakiaHospitalPatientsService> getSlovakiaHospitalPatients(){
        return slovakiaHospitalPatientsService.getSlovakiaHospitalPatients();
    }
}

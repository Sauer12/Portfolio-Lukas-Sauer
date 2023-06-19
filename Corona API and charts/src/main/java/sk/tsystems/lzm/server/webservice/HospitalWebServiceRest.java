package sk.tsystems.lzm.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tsystems.lzm.entity.City;
import sk.tsystems.lzm.entity.Hospital;
import sk.tsystems.lzm.service.CityService;
import sk.tsystems.lzm.service.HospitalService;

import java.util.List;

@RestController
@RequestMapping("/api/hospitals")
public class HospitalWebServiceRest {

    @Autowired
    private HospitalService hospitalService;

    //localhost:8080/api/hospitals
    @PostMapping
    void addHospital(@RequestBody Hospital hospital){
        hospitalService.addHospital(hospital);
    }

    @GetMapping
    List<Hospital> getHospitals(){
        return hospitalService.getHospitals();
    }
}

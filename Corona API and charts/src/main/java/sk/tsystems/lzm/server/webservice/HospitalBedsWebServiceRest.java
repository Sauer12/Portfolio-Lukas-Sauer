package sk.tsystems.lzm.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tsystems.lzm.entity.HospitalBeds;
import sk.tsystems.lzm.service.HospitalBedsService;

import java.util.List;

@RestController
@RequestMapping("/api/HospitalBeds")
public class HospitalBedsWebServiceRest {
    @Autowired
    private HospitalBedsService hospitalBedsService;

    @PostMapping
    void addHospitalBeds(@RequestBody HospitalBeds hospitalBeds){
        hospitalBedsService.addHospitalBeds(hospitalBeds);
    }

    @GetMapping
    public List<HospitalBeds> getAllHospitalBeds(){
        return hospitalBedsService.getAllHospitalBeds();
    }
}

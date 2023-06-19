package sk.tsystems.lzm.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tsystems.lzm.entity.SlovakiaHospitalBeds;
import sk.tsystems.lzm.service.SlovakiaHospitalBedsService;

import java.util.List;

@RestController
@RequestMapping("/api/slovakiaHospitalBeds")
public class SlovakiaHospitalBedsWebServiceRest {

    @Autowired
    private SlovakiaHospitalBedsService slovakiaHospitalBedsService;

    @PostMapping
    void addSlovakiaHospitalBeds(@RequestBody SlovakiaHospitalBeds slovakiaHospitalBeds){
        slovakiaHospitalBedsService.addSlovakiaHospitalBeds(slovakiaHospitalBeds);
    }

    @GetMapping
    public List<SlovakiaHospitalBeds> getAllSlovakiaHospitalBeds(){
        return slovakiaHospitalBedsService.getAllSlovakiaHospitalBeds();
    }
}

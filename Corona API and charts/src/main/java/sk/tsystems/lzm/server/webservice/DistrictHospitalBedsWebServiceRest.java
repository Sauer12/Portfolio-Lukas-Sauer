package sk.tsystems.lzm.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tsystems.lzm.entity.DistrictHospitalBeds;
import sk.tsystems.lzm.service.DistrictHospitalBedsService;

import java.util.List;

@RestController
@RequestMapping("/api/districtHospitalBeds")
public class DistrictHospitalBedsWebServiceRest {

    @Autowired
    private DistrictHospitalBedsService districtHospitalBedsService;

    @PostMapping
    void addDistrictHospitalBeds(@RequestBody DistrictHospitalBeds districtHospitalBeds){
        districtHospitalBedsService.addDistrictHospitalBeds(districtHospitalBeds);
    }

    @GetMapping
    public List<DistrictHospitalBeds> getAllDistrictHospitalBeds(){
        return districtHospitalBedsService.getAllDistrictHospitalBeds();
    }
}

package sk.tsystems.lzm.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tsystems.lzm.entity.DistrictHospitalBeds;
import sk.tsystems.lzm.entity.RegionHospitalBeds;
import sk.tsystems.lzm.service.RegionHospitalBedsService;

import java.util.List;

@RestController
@RequestMapping("/api/regionHospitalBeds")
public class RegionHospitalBedsWebServiceRest {

    @Autowired
    private RegionHospitalBedsService regionHospitalBedsService;

    @PostMapping
    void addRegionHospitalBeds(@RequestBody RegionHospitalBeds regionHospitalBeds){
        regionHospitalBedsService.addRegionHospitalBeds(regionHospitalBeds);
    }

    @GetMapping
    public List<RegionHospitalBeds> getAllRegionHospitalBeds(){
        return regionHospitalBedsService.getAllRegionHospitalBeds();
    }
}

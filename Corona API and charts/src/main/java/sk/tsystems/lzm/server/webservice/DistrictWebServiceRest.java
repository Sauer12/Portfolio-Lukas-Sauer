package sk.tsystems.lzm.server.webservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tsystems.lzm.entity.City;
import sk.tsystems.lzm.entity.District;
import sk.tsystems.lzm.service.CityService;
import sk.tsystems.lzm.service.DistrictService;

import java.util.List;

@RestController
@RequestMapping("/api/districts")
public class DistrictWebServiceRest {

    @Autowired
    private DistrictService districtService;

    //localhost:8080/api/districts
    @PostMapping
    void addDistrict(@RequestBody District district){
        districtService.addDistrict(district);
    }

    @GetMapping
    List<District> getDistricts(){
        return districtService.getDistricts();
    }
}

package sk.tsystems.lzm.server.webservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tsystems.lzm.entity.DistrictAgTests;
import sk.tsystems.lzm.service.DistrictAgTestsService;

import java.util.List;

@RestController
@RequestMapping("/api/districtAgTests")
public class DistrictAgTestsWebServiceRest {

    @Autowired
    private DistrictAgTestsService districtAgTestsService;


    @PostMapping
    void addDistrictAgTests(@RequestBody DistrictAgTests districtAgTests) {
        districtAgTestsService.addDistrictAgTests(districtAgTests);
    }

    @GetMapping
    List<DistrictAgTests> getDistrictAgTests(){
        return districtAgTestsService.getDistrictAgTestsAll();
    }
}

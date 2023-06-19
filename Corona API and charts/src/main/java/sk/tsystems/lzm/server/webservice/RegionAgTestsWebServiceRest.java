package sk.tsystems.lzm.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tsystems.lzm.entity.RegionAgTests;
import sk.tsystems.lzm.service.RegionAgTestsService;

import java.util.List;

@RestController
@RequestMapping("/api/regionAgTests")
public class RegionAgTestsWebServiceRest {

    @Autowired
    private RegionAgTestsService regionAgTestsService;

    @PostMapping
    void addRegionAgTestsAll(@RequestBody RegionAgTests regionAgTests){
        regionAgTestsService.addRegionAgTests(regionAgTests);
    }

    @GetMapping
    List<RegionAgTests> getRegionAgTestsAll(){
        return regionAgTestsService.getRegionAgTestsAll();
    }
}

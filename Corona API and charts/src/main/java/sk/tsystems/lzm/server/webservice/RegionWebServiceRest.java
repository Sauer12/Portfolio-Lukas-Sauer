package sk.tsystems.lzm.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tsystems.lzm.entity.Region;
import sk.tsystems.lzm.service.RegionService;

import java.util.List;

@RestController
@RequestMapping("/api/regions")
public class RegionWebServiceRest {

    @Autowired
    private RegionService regionService;

    @PostMapping
    void addRegion(@RequestBody Region region){
        regionService.addRegion(region);
    }

    @GetMapping
    List<Region> getRegions(){
        return regionService.getRegions();
    }

}

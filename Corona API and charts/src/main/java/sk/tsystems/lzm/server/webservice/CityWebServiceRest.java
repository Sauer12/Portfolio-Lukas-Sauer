package sk.tsystems.lzm.server.webservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tsystems.lzm.entity.City;
import sk.tsystems.lzm.service.CityService;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityWebServiceRest {

    @Autowired
    private CityService cityService;

    //localhost:8080/api/cities
    @PostMapping
    void addCity(@RequestBody City city){
        cityService.addCity(city);
    }

    @GetMapping
    List<City> getCities(){
        return cityService.getCities();
    }

}

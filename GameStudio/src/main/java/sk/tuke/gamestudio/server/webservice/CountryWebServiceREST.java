package sk.tuke.gamestudio.server.webservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tuke.gamestudio.entity.Country;
import sk.tuke.gamestudio.service.CountryService;

import java.util.List;

@RestController
@RequestMapping("/api/country")
public class CountryWebServiceREST {

    @Autowired
    private CountryService countryService;

    @GetMapping
    List<Country> getCountries(){
        return countryService.getCountries();
    }

    @PostMapping
    void addCountry(@RequestBody Country country){
        countryService.addCountry(country);
    }
}

package sk.tuke.gamestudio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import sk.tuke.gamestudio.entity.Country;

import java.util.Arrays;
import java.util.List;

public class CountryServiceREST implements CountryService{
    private final String url = "http://localhost:8080/api";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Country> getCountries() {
        return Arrays.asList(restTemplate.getForEntity(url + "/country", Country[].class).getBody());
    }

    @Override
    public void addCountry(Country country) {
        restTemplate.postForEntity(url + "/country", country, Country.class);
    }
}


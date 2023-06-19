package sk.tuke.gamestudio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import sk.tuke.gamestudio.entity.Occupation;

import java.util.Arrays;
import java.util.List;

public class OccupationServiceREST implements OccupationService{

    private final String url = "http://localhost:8080/api";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Occupation> getOccupations() {
        return Arrays.asList(restTemplate.getForEntity(url + "/occupation", Occupation[].class).getBody());
    }

    @Override
    public void addOccupation(Occupation occupation) {
        restTemplate.postForEntity(url + "/occupation", occupation, Occupation.class);
    }
}

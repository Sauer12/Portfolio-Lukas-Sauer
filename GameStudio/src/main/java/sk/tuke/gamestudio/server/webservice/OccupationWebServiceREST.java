package sk.tuke.gamestudio.server.webservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tuke.gamestudio.entity.Occupation;
import sk.tuke.gamestudio.service.OccupationService;

import java.util.List;

@RestController
@RequestMapping("/api/occupation")
public class OccupationWebServiceREST {

    @Autowired
    private OccupationService occupationService;

    @GetMapping
    List<Occupation> getOccupations(){
        return occupationService.getOccupations();
    }

    @PostMapping
    void addOccupation(@RequestBody Occupation occupation){
        occupationService.addOccupation(occupation);
    }
}

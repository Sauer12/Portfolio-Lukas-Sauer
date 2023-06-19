package sk.tsystems.lzm.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tsystems.lzm.entity.DistrictHospitalPatients;
import sk.tsystems.lzm.service.DistrictHospitalPatientsService;

import java.util.List;

@RestController
@RequestMapping("/api/districtHospitalPatients")
public class DistrictHospitalPatientsWebServiceRest {
    @Autowired
    private DistrictHospitalPatientsService districtHospitalPatientsService;

    @PostMapping
    void addDistrictHospitalPatients(@RequestBody DistrictHospitalPatients districtHospitalPatients){
        districtHospitalPatientsService.addDistrictHospitalPatients(districtHospitalPatients);
    }

    @GetMapping
    public List<DistrictHospitalPatients> getAllDistrictHospitalPatients(){
        return districtHospitalPatientsService.getAllDistrictHospitalPatients();
    }
}

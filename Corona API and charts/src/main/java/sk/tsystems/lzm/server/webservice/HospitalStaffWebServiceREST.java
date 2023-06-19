package sk.tsystems.lzm.server.webservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.tsystems.lzm.entity.HospitalStaff;
import sk.tsystems.lzm.service.HospitalStaffService;

import java.util.List;

@RestController
@RequestMapping("/api/hospitalstaff")
public class HospitalStaffWebServiceREST {

    @Autowired
    private HospitalStaffService hospitalStaffService;

    @PostMapping
    void addHospitalStaff(@RequestBody HospitalStaff hospitalStaff){
        hospitalStaffService.addHospitalStaff(hospitalStaff);
    }

    List<HospitalStaff> getHospitalStaff(){
        return hospitalStaffService.getHospitalStaff();
    }
}

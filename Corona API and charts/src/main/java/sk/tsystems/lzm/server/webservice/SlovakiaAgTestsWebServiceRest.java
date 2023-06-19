package sk.tsystems.lzm.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tsystems.lzm.entity.SlovakiaAgTests;
import sk.tsystems.lzm.service.SlovakiaAgTestsService;

import java.util.List;

@RestController
@RequestMapping("/api/slovakiaAgTests")
public class SlovakiaAgTestsWebServiceRest {

    @Autowired
    private SlovakiaAgTestsService slovakiaAgTestsService;


    @PostMapping
    void addSlovakiaAgTests(@RequestBody SlovakiaAgTests slovakiaAgTests){
        slovakiaAgTestsService.addSlovakiaAgTests(slovakiaAgTests);
    }

    @GetMapping
    List<SlovakiaAgTests> getSlovakiaAgTestsAll(){
        return slovakiaAgTestsService.getSlovakiaAgTestsAll();
    }
}

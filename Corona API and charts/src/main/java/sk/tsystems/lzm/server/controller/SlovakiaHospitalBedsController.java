package sk.tsystems.lzm.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import sk.tsystems.lzm.App;
import sk.tsystems.lzm.service.SlovakiaHospitalBedsService;
import sk.tsystems.lzm.sourceAPI.SlovakiaAgTestsAPI;
import sk.tsystems.lzm.sourceAPI.SlovakiaHospitalBedsAPI;

import javax.transaction.Transaction;

@Controller
@RequestMapping("slovakiaHospitalBeds")
public class SlovakiaHospitalBedsController {
    @Autowired
    SlovakiaHospitalBedsService slovakiaHospitalBedsService;

    String apiUrl = "https://data.korona.gov.sk/api/hospital-beds/in-slovakia";

    //    po kazdom otvoreni stranky sa data naloaduju ak naloadovane nie su
    @RequestMapping
    public String updatePage(){
        loadData();
        return ("slovakiaHospitalBeds");
    }

    //    Download alebo 'Update' dat, ak su data aktualne, nestane sa nic - ma to vsak hacik (zmena minulych dat zo strany poskytovatela dat)
    private void loadData() {
        slovakiaHospitalBedsService.reset();
        App app = new App();
        String responseContent = app.loadResponse(apiUrl).toString();
        Transaction transaction = null;
        SlovakiaHospitalBedsAPI slovakiaHospitalBedsAPI = new SlovakiaHospitalBedsAPI();
        if (!responseContent.contains("error!")) {
            if (slovakiaHospitalBedsService.getAllSlovakiaHospitalBeds().isEmpty()) {
                slovakiaHospitalBedsAPI.slovakiaHospitalBedsToDb(responseContent, slovakiaHospitalBedsService);
            }
        }
    }
}

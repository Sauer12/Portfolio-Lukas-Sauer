package sk.tsystems.lzm.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import sk.tsystems.lzm.App;
import sk.tsystems.lzm.entity.RegionHospitalBeds;
import sk.tsystems.lzm.service.RegionHospitalBedsService;
import sk.tsystems.lzm.service.RegionService;
import sk.tsystems.lzm.sourceAPI.RegionAPI;
import sk.tsystems.lzm.sourceAPI.RegionAgTestsAPI;
import sk.tsystems.lzm.sourceAPI.RegionHospitalBedsAPI;

@Controller
@RequestMapping("regionHospitalBeds")
public class RegionHospitalBedsController {

    @Autowired
    RegionHospitalBedsService regionHospitalBedsService;

    @Autowired
    RegionService regionService;

    String apiUrlRegionHospitalBeds = "https://data.korona.gov.sk/api/hospital-beds/by-region";
    String apiUrlRegion = "https://data.korona.gov.sk/api/regions";

    //    po kazdom otvoreni stranky sa data naloaduju ak naloadovane nie su
    @RequestMapping
    public String updatePage(){
        loadData();
        return ("regionAgTests");
    }

    //    Download alebo 'Update' dat, ak su data aktualne, nestane sa nic - ma to vsak hacik (zmena minulych dat zo strany poskytovatela dat)
    private void loadData() {
        regionHospitalBedsService.reset();
        App app = new App();
        String responseContent = app.loadResponse(apiUrlRegion).toString();

        if (!responseContent.contains("error!")) {
            if (regionService.getRegions().isEmpty()) {
                RegionAPI regionAPI = new RegionAPI();
                regionAPI.regionToDb(responseContent, regionService);
            }
        }

        responseContent = app.loadResponse(apiUrlRegionHospitalBeds).toString();
        if (!responseContent.contains("error!")) {
            if (regionHospitalBedsService.getAllRegionHospitalBeds().isEmpty()) {
                RegionHospitalBedsAPI regionHospitalBedsAPI = new RegionHospitalBedsAPI();
                regionHospitalBedsAPI.regionHospitalBedsToDb(responseContent, regionHospitalBedsService, regionService);
            }
        }

    }
}

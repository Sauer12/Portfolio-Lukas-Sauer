package sk.tsystems.lzm.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import sk.tsystems.lzm.App;
import sk.tsystems.lzm.service.RegionAgTestsService;
import sk.tsystems.lzm.service.RegionService;
import sk.tsystems.lzm.service.RegionVaccinationsService;
import sk.tsystems.lzm.sourceAPI.RegionAPI;
import sk.tsystems.lzm.sourceAPI.RegionAgTestsAPI;
import sk.tsystems.lzm.sourceAPI.RegionVaccinationsAPI;

@Controller
@RequestMapping("regionVaccinations")
public class RegionVaccinationsController {
    @Autowired
    RegionVaccinationsService regionVaccinationsService;
    @Autowired
    RegionService regionService;

    String apiUrlRegionVaccinations = "https://data.korona.gov.sk/api/vaccinations/by-region";
    String apiUrlRegion = "https://data.korona.gov.sk/api/regions";

    //    po kazdom otvoreni stranky sa data naloaduju ak naloadovane nie su
    @RequestMapping
    public String updatePage(){
        loadData();
        return ("regionVaccinations");
    }

    //    Download alebo 'Update' dat, ak su data aktualne, nestane sa nic - ma to vsak hacik (zmena minulych dat zo strany poskytovatela dat)
    private void loadData() {
        regionVaccinationsService.reset();
        App app = new App();
        String responseContent = app.loadResponse(apiUrlRegion).toString();

        if (!responseContent.contains("error!")) {
            if (regionService.getRegions().isEmpty()) {
                RegionAPI regionAPI = new RegionAPI();
                regionAPI.regionToDb(responseContent, regionService);
            }
        }

        responseContent = app.loadResponse(apiUrlRegionVaccinations).toString();
        if (!responseContent.contains("error!")) {
            if (regionVaccinationsService.getRegionVaccinations().isEmpty()) {
                RegionVaccinationsAPI regionVaccinationsAPI = new RegionVaccinationsAPI();
                regionVaccinationsAPI.regionVaccinationsToDb(responseContent, regionVaccinationsService, regionService);
            }
        }

    }
}

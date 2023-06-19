package sk.tsystems.lzm.server.controller;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import sk.tsystems.lzm.App;
import sk.tsystems.lzm.service.SlovakiaAgTestsService;
import sk.tsystems.lzm.sourceAPI.SlovakiaAgTestsAPI;

import javax.transaction.Transaction;


@Controller
@RequestMapping("developmentOfAgTests")
public class SlovakiaAgTestsController {
    @Autowired
    SlovakiaAgTestsService slovakiaAgTestsService;

    String apiUrl = "https://data.korona.gov.sk/api/ag-tests/in-slovakia";

//    po kazdom otvoreni stranky sa data naloaduju ak naloadovane nie su
    @RequestMapping
    public String updatePage(){
        loadData();
        return ("developmentOfAgTests");
    }

//    Download alebo 'Update' dat, ak su data aktualne, nestane sa nic - ma to vsak hacik (zmena minulych dat zo strany poskytovatela dat)
    private void loadData() {
//        slovakiaAgTestsService.reset();
        App app = new App();
        String responseContent = app.loadResponse(apiUrl).toString();
        Transaction transaction = null;
        SlovakiaAgTestsAPI slovakiaAgTestsAPI = new SlovakiaAgTestsAPI();
        if(!responseContent.contains("error!")){
            if (slovakiaAgTestsService.getSlovakiaAgTestsAll().isEmpty()) {
                slovakiaAgTestsAPI.slovakiaAgTestsToDb(responseContent, slovakiaAgTestsService);
            }
//            nefunguje - problem
            else {
                if(isIdUrlBigger(responseContent)){
                    System.out.println("Vykonal sa update!");
                    slovakiaAgTestsAPI.slovakiaAgTestsToDb(responseContent, slovakiaAgTestsService);
                }
            }
        }
    }

//    Zisti ci posledne ID v nasej databaze je mensie alebo rovne ako ID v API url
    private boolean isIdUrlBigger(String response){
        JSONObject slovakiaAgTests = new JSONObject(response);
        JSONArray slovakiaAgTestsList = slovakiaAgTests.getJSONArray("page");

        Long apiUrlLastId = Long.parseLong(slovakiaAgTestsList.getJSONObject(0).getString("id"));
        Long dbLastId = Long.parseLong(slovakiaAgTestsService.getLastId());

        if(dbLastId < apiUrlLastId)
            return true;
        else
            return false;
    }
}

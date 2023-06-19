package sk.tsystems.lzm.sourceAPI;

import org.json.JSONArray;
import org.json.JSONObject;
import sk.tsystems.lzm.entity.City;
import sk.tsystems.lzm.entity.Vaccine;
import sk.tsystems.lzm.service.CityService;
import sk.tsystems.lzm.service.DistrictService;
import sk.tsystems.lzm.service.VaccineService;

public class VaccineAPI {
    public void vaccineToDb(String responseBody, VaccineService vaccineService){
        JSONArray vaccines = new JSONArray(responseBody);
        if(vaccineService.getAllVaccine().isEmpty()) {
            for(int i = 0; i < vaccines.length(); i++) {
                JSONObject vaccine = vaccines.getJSONObject(i);
                int id = vaccine.getInt("id");
                String title = vaccine.getString("title");
                String manufacturer = vaccine.getString("manufacturer");
                vaccineService.addVaccine(new Vaccine(id, title, manufacturer));
            }
        }
    }
}

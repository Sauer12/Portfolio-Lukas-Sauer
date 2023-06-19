package sk.tsystems.lzm.sourceAPI;

import org.json.JSONArray;
import org.json.JSONObject;
import sk.tsystems.lzm.entity.City;
import sk.tsystems.lzm.service.CityService;
import sk.tsystems.lzm.service.DistrictService;

public class CityAPI {

    public void cityToDb(String responseBody, CityService cityService, DistrictService districtService){
        JSONArray cities = new JSONArray(responseBody);
        if(cityService.getCities().isEmpty()) {
            for(int i = 0; i < cities.length(); i++) {
                JSONObject city = cities.getJSONObject(i);
                int districtId = city.getInt("district_id");
                int id = city.getInt("id");
                String title = city.getString("title");
                String code = city.getString("code");
                cityService.addCity(new City(id, districtService.getDistricts().get(districtId - 1), title, code));
            }
        }
    }
}

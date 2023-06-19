package sk.tsystems.lzm.sourceAPI;

import org.json.JSONArray;
import org.json.JSONObject;
import sk.tsystems.lzm.entity.Hospital;
import sk.tsystems.lzm.service.CityService;
import sk.tsystems.lzm.service.HospitalService;

public class HospitalAPI {
    /*public void hospitalToDb(String responseBody, HospitalService hospitalService, CityService cityService){
        JSONArray hospitals = new JSONArray(responseBody);
        if(hospitalService.getHospitals().isEmpty()){
            for(int i = 0; i < hospitals.length(); i++) {
                JSONObject hospital = hospitals.getJSONObject(i);
                int cityId = hospital.getInt("city_id");
                int id = hospital.getInt("id");
                String title = hospital.getString("title");
                String code = hospital.getString("code");

                hospitalService.addHospital(new Hospital(id, cityService.getCities().get(cityId - 1), title, code));
            }
        }
    }*/

    public void hospitalToDb(String responseBody, HospitalService hospitalService, CityService cityService){
        JSONArray hospitals = new JSONArray(responseBody);
        if(hospitalService.getHospitals().isEmpty()) {
            for (int i = 0; i < hospitals.length(); i++) {
                JSONObject hospital = hospitals.getJSONObject(i);
                int id = hospital.getInt("id");
                int cityId = hospital.getInt("city_id");
                String title = hospital.getString("title");
                String code = hospital.getString("code");
                hospitalService.addHospital(new Hospital(id, cityService.getCities().get(cityId-1), title, code));
            }
        }
    }
}

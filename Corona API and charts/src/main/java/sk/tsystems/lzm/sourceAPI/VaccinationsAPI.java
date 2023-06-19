package sk.tsystems.lzm.sourceAPI;

import org.json.JSONArray;
import org.json.JSONObject;
import sk.tsystems.lzm.entity.Vaccinations;
import sk.tsystems.lzm.service.RegionService;
import sk.tsystems.lzm.service.VaccinationsService;
import sk.tsystems.lzm.service.VaccineService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VaccinationsAPI {

    public void vaccinationsToDb(String responseBody, VaccineService vaccineService, RegionService regionService, VaccinationsService vaccinationsService){
        JSONObject vaccinations = new JSONObject(responseBody);
        JSONArray arrayJson = vaccinations.getJSONArray("page");
        SimpleDateFormat formatterDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat formatterDateOnly = new SimpleDateFormat("yyyy-MM-dd");

        if(vaccinationsService.getVaccinations().isEmpty()){
            for(int i = 0; i < arrayJson.length(); i++){
                int vaccineId = arrayJson.getJSONObject(i).getInt("vaccine_id");
                int regionId = arrayJson.getJSONObject(i).getInt("region_id");
                String id = arrayJson.getJSONObject(i).getString("id");
                int dose1Count = arrayJson.getJSONObject(i).getInt("dose1_count");
                int dose2Count = arrayJson.getJSONObject(i).getInt("dose2_count");
                String updatedAt = arrayJson.getJSONObject(i).getString("updated_at");
                String publishedOn = arrayJson.getJSONObject(i).getString("published_on");

                Date updatedAtParsed = null;
                Date publishedOnParsed = null;
                try {
                    updatedAtParsed = formatterDate.parse(updatedAt);
                    publishedOnParsed = formatterDateOnly.parse(publishedOn);
                } catch (ParseException e) {
                    System.out.println(e.getMessage());
                }

                vaccinationsService.addVaccinations(new Vaccinations(id, vaccineService.getVaccine(vaccineId), regionService.getRegions().get(regionId - 1),
                        dose1Count, dose2Count, updatedAtParsed, publishedOnParsed));
            }
        }
    }
}

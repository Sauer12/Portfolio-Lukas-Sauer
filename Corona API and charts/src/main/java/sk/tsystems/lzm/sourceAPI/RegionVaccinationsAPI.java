package sk.tsystems.lzm.sourceAPI;

import org.json.JSONArray;
import org.json.JSONObject;
import sk.tsystems.lzm.entity.RegionHospitalBeds;
import sk.tsystems.lzm.entity.RegionVaccinations;
import sk.tsystems.lzm.service.RegionService;
import sk.tsystems.lzm.service.RegionVaccinationsService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegionVaccinationsAPI {

    public void regionVaccinationsToDb(String responseBody, RegionVaccinationsService regionVaccinationsService, RegionService regionService) {

        JSONObject regionVaccinations = new JSONObject(responseBody);
        JSONArray arrayJson = regionVaccinations.getJSONArray("page");

        if(regionVaccinationsService.getRegionVaccinations().isEmpty()) {
            for(int i = 0; i < arrayJson.length(); i++) {

                String id = arrayJson.getJSONObject(i).getString("id");
                int regionId = arrayJson.getJSONObject(i).getInt("region_id");

                int dose1Count = arrayJson.getJSONObject(i).getInt("dose1_count");
                int dose2Count = arrayJson.getJSONObject(i).getInt("dose2_count");
                int dose1Sum = arrayJson.getJSONObject(i).getInt("dose1_sum");
                int dose2Sum = arrayJson.getJSONObject(i).getInt("dose2_sum");

                String updatedAt = arrayJson.getJSONObject(i).getString("updated_at");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date updated_at = null;

                String publishedOn = arrayJson.getJSONObject(i).getString("published_on");
                SimpleDateFormat othersdf = new SimpleDateFormat("yyyy-MM-dd");
                Date published_on = null;
                try {
                    published_on = othersdf.parse(publishedOn);
                    updated_at = sdf.parse(updatedAt);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }

                regionVaccinationsService.addRegionVaccinations(
                        new RegionVaccinations(
                                id,
                                regionService.getRegions().get(regionId-1),
                                dose1Count,
                                dose2Count,
                                dose1Sum,
                                dose2Sum,
                                published_on,
                                updated_at));
            }
        }
    }
}

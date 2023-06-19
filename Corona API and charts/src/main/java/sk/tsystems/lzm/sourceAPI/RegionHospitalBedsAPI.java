package sk.tsystems.lzm.sourceAPI;

import org.json.JSONArray;
import org.json.JSONObject;
import sk.tsystems.lzm.entity.DistrictHospitalBeds;
import sk.tsystems.lzm.entity.RegionHospitalBeds;
import sk.tsystems.lzm.service.DistrictHospitalBedsService;
import sk.tsystems.lzm.service.DistrictService;
import sk.tsystems.lzm.service.RegionHospitalBedsService;
import sk.tsystems.lzm.service.RegionService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegionHospitalBedsAPI {

    public void regionHospitalBedsToDb(String responseBody, RegionHospitalBedsService regionHospitalBedsService, RegionService regionService) {

        JSONObject regionHospitalBeds = new JSONObject(responseBody);
        JSONArray arrayJson = regionHospitalBeds.getJSONArray("page");

        if(regionHospitalBedsService.getAllRegionHospitalBeds().isEmpty()) {
            for(int i = 0; i < arrayJson.length(); i++) {
                String oldestReportedAt = arrayJson.getJSONObject(i).getString("oldest_reported_at");
                String newestReportedAt = arrayJson.getJSONObject(i).getString("newest_reported_at");
                String publishedOn = arrayJson.getJSONObject(i).getString("published_on");

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                SimpleDateFormat othersdf = new SimpleDateFormat("yyyy-MM-dd");

                int regionId = arrayJson.getJSONObject(i).getInt("region_id");
                long id = arrayJson.getJSONObject(i).getLong("id");

                int capacityAll = arrayJson.getJSONObject(i).getInt("capacity_all");
                int freeAll = arrayJson.getJSONObject(i).getInt("free_all");
                int capacityCovid = arrayJson.getJSONObject(i).getInt("capacity_covid");
                int occupiedJisCovid = arrayJson.getJSONObject(i).getInt("occupied_jis_covid");
                int occupiedOaimCovid = arrayJson.getJSONObject(i).getInt("occupied_oaim_covid");
                int occupiedO2Covid = arrayJson.getJSONObject(i).getInt("occupied_o2_covid");
                int occupiedOtherCovid = arrayJson.getJSONObject(i).getInt("occupied_other_covid");
                String updatedAt = arrayJson.getJSONObject(i).getString("updated_at");

                Date oldest_reported_at = null;
                Date newest_reported_at = null;
                Date published_on = null;
                Date updated_at = null;


                try {
                    oldest_reported_at = sdf.parse(oldestReportedAt);
                    newest_reported_at = sdf.parse(newestReportedAt);
                    published_on = othersdf.parse(publishedOn);
                    updated_at = sdf.parse(updatedAt);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }

                regionHospitalBedsService.addRegionHospitalBeds(
                        new RegionHospitalBeds(
                                id,
                                oldest_reported_at,
                                newest_reported_at,
                                published_on,
                                regionService.getRegions().get(regionId-1),
                                capacityAll,
                                freeAll,
                                capacityCovid,
                                occupiedJisCovid,
                                occupiedOaimCovid,
                                occupiedO2Covid,
                                occupiedOtherCovid,
                                updated_at));
            }
        }
    }
}

package sk.tsystems.lzm.sourceAPI;

import org.json.JSONArray;
import org.json.JSONObject;
import sk.tsystems.lzm.entity.DistrictHospitalBeds;
import sk.tsystems.lzm.entity.SlovakiaHospitalBeds;
import sk.tsystems.lzm.service.DistrictHospitalBedsService;
import sk.tsystems.lzm.service.DistrictService;
import sk.tsystems.lzm.service.SlovakiaHospitalBedsService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DistrictHospitalBedsAPI {

    public void districtHospitalBedsToDb(String responseBody, DistrictHospitalBedsService districtHospitalBedsService, DistrictService districtService) throws ParseException {

        JSONObject districtHospitalBeds = new JSONObject(responseBody);
        JSONArray arrayJson = districtHospitalBeds.getJSONArray("page");

        if(districtHospitalBedsService.getAllDistrictHospitalBeds().isEmpty()) {
            for(int i = 0; i < arrayJson.length(); i++) {
                String oldestReportedAt = arrayJson.getJSONObject(i).getString("oldest_reported_at");
                String newestReportedAt = arrayJson.getJSONObject(i).getString("newest_reported_at");
                String publishedOn = arrayJson.getJSONObject(i).getString("published_on");

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                Date oldest_reported_at = sdf.parse(oldestReportedAt);
                Date newest_reported_at = sdf.parse(newestReportedAt);

                SimpleDateFormat othersdf = new SimpleDateFormat("yyyy-MM-dd");
                Date published_on = othersdf.parse(publishedOn);

                int districtId = arrayJson.getJSONObject(i).getInt("district_id");
                long id = arrayJson.getJSONObject(i).getLong("id");

                int capacityAll = arrayJson.getJSONObject(i).getInt("capacity_all");
                int freeAll = arrayJson.getJSONObject(i).getInt("free_all");
                int capacityCovid = arrayJson.getJSONObject(i).getInt("capacity_covid");
                int occupiedJisCovid = arrayJson.getJSONObject(i).getInt("occupied_jis_covid");
                int occupiedOaimCovid = arrayJson.getJSONObject(i).getInt("occupied_oaim_covid");
                int occupiedO2Covid = arrayJson.getJSONObject(i).getInt("occupied_o2_covid");
                int occupiedOtherCovid = arrayJson.getJSONObject(i).getInt("occupied_other_covid");
                String updatedAt = arrayJson.getJSONObject(i).getString("updated_at");
                Date updated_at = sdf.parse(updatedAt);

                districtHospitalBedsService.addDistrictHospitalBeds(
                        new DistrictHospitalBeds(
                                id,
                                oldest_reported_at,
                                newest_reported_at,
                                published_on,
                                districtService.getDistricts().get(districtId-1),
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

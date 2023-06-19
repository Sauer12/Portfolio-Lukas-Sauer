package sk.tsystems.lzm.sourceAPI;

import org.json.JSONArray;
import org.json.JSONObject;
import sk.tsystems.lzm.entity.City;
import sk.tsystems.lzm.entity.SlovakiaHospitalBeds;
import sk.tsystems.lzm.service.CityService;
import sk.tsystems.lzm.service.DistrictService;
import sk.tsystems.lzm.service.SlovakiaHospitalBedsService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SlovakiaHospitalBedsAPI {
    public void slovakiaHospitalBedsToDb(String responseBody, SlovakiaHospitalBedsService slovakiaHospitalBedsService) {

        JSONObject slovakiaHospitalBeds = new JSONObject(responseBody);
        JSONArray arrayJson = slovakiaHospitalBeds.getJSONArray("page");

        if(slovakiaHospitalBedsService.getAllSlovakiaHospitalBeds().isEmpty()) {
            for(int i = 0; i < arrayJson.length(); i++) {
                slovakiaHospitalBeds = arrayJson.getJSONObject(i);
                long id = arrayJson.getJSONObject(i).getLong("id");
                String oldestReportedAt = slovakiaHospitalBeds.getString("oldest_reported_at");
                String newestReportedAt = slovakiaHospitalBeds.getString("newest_reported_at");
                String publishedOn = slovakiaHospitalBeds.getString("published_on");

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                SimpleDateFormat othersdf = new SimpleDateFormat("yyyy-MM-dd");

                Date oldest_reported_at = null;
                Date newest_reported_at = null;
                Date published_on = null;
                try {
                    oldest_reported_at = sdf.parse(oldestReportedAt);
                    newest_reported_at = sdf.parse(newestReportedAt);
                    published_on = othersdf.parse(publishedOn);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }



                int capacityAll = slovakiaHospitalBeds.getInt("capacity_all");
                int freeAll = slovakiaHospitalBeds.getInt("free_all");
                int capacityCovid = slovakiaHospitalBeds.getInt("capacity_covid");
                int occupiedJisCovid = slovakiaHospitalBeds.getInt("occupied_jis_covid");
                int occupiedOaimCovid = slovakiaHospitalBeds.getInt("occupied_oaim_covid");
                int occupiedO2Covid = slovakiaHospitalBeds.getInt("occupied_o2_covid");
                int occupiedOtherCovid = slovakiaHospitalBeds.getInt("occupied_other_covid");
                String updatedAt = slovakiaHospitalBeds.getString("updated_at");

                Date updated_at = null;
                try {
                    updated_at = sdf.parse(updatedAt);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }

                slovakiaHospitalBedsService.addSlovakiaHospitalBeds(new SlovakiaHospitalBeds(id, oldest_reported_at, newest_reported_at, published_on, capacityAll, freeAll, capacityCovid, occupiedJisCovid, occupiedOaimCovid, occupiedO2Covid, occupiedOtherCovid, updated_at));
            }
        }
    }
}

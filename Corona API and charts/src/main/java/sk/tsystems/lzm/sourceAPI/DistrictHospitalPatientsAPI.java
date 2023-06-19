package sk.tsystems.lzm.sourceAPI;

import org.json.JSONArray;
import org.json.JSONObject;
import sk.tsystems.lzm.entity.DistrictHospitalPatients;
import sk.tsystems.lzm.service.DistrictHospitalPatientsService;
import sk.tsystems.lzm.service.DistrictService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DistrictHospitalPatientsAPI {

    public void districtHospitalPatientsToDb(String responseBody, DistrictHospitalPatientsService districtHospitalPatientsService, DistrictService districtService) throws ParseException {

        JSONObject districtHospitalPatients = new JSONObject(responseBody);
        JSONArray arrayJson = districtHospitalPatients.getJSONArray("page");

        if(districtHospitalPatientsService.getAllDistrictHospitalPatients().isEmpty()) {
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

                int ventilatedCovid = arrayJson.getJSONObject(i).getInt("ventilated_covid");
                int nonCovid = arrayJson.getJSONObject(i).getInt("non_covid");
                int confirmedCovid = arrayJson.getJSONObject(i).getInt("confirmed_covid");
                int suspectedCovid = arrayJson.getJSONObject(i).getInt("suspected_covid");
                String updatedAt = arrayJson.getJSONObject(i).getString("updated_at");
                Date updated_at = sdf.parse(updatedAt);

                districtHospitalPatientsService.addDistrictHospitalPatients(
                        new DistrictHospitalPatients(
                                id,
                                oldest_reported_at,
                                newest_reported_at,
                                published_on,
                                districtService.getDistricts().get(districtId-1),
                                ventilatedCovid,
                                nonCovid,
                                confirmedCovid,
                                suspectedCovid,
                                updated_at));
            }
        }
    }
}

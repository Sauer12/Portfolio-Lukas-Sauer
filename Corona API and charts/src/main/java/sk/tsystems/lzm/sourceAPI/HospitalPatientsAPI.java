package sk.tsystems.lzm.sourceAPI;

import org.json.JSONArray;
import org.json.JSONObject;
import sk.tsystems.lzm.entity.HospitalPatients;
import sk.tsystems.lzm.service.HospitalPatientsService;
import sk.tsystems.lzm.service.HospitalService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HospitalPatientsAPI {

    public void hospitalPatientsToDb(String responseBody, HospitalPatientsService hospitalPatientsService, HospitalService hospitalService) throws ParseException {

        JSONObject hospitalPatients = new JSONObject(responseBody);
        JSONArray arrayJson = hospitalPatients.getJSONArray("page");

        if (hospitalPatientsService.getAllHospitalPatients().isEmpty()) {
            for (int i = 0; i < arrayJson.length(); i++) {

                int hospitalId = arrayJson.getJSONObject(i).getInt("hospital_id");
                long id = arrayJson.getJSONObject(i).getLong("id");

                String reportedAt = arrayJson.getJSONObject(i).getString("reported_at");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date reported_at = sdf.parse(reportedAt);

                int ventilatedCovid = arrayJson.getJSONObject(i).getInt("ventilated_covid");
                int nonCovid = arrayJson.getJSONObject(i).getInt("non_covid");
                int confirmedCovid = arrayJson.getJSONObject(i).getInt("confirmed_covid");
                int suspectedCovid = arrayJson.getJSONObject(i).getInt("suspected_covid");

                String updatedAt = arrayJson.getJSONObject(i).getString("updated_at");
                Date updated_at = sdf.parse(updatedAt);

                String publishedOn = arrayJson.getJSONObject(i).getString("published_on");
                SimpleDateFormat othersdf = new SimpleDateFormat("yyyy-MM-dd");
                Date published_on = othersdf.parse(publishedOn);

                hospitalPatientsService.addHospitalPatients(
                        new HospitalPatients(
                                id,
                                hospitalService.getHospital(hospitalId),
                                reported_at,
                                ventilatedCovid,
                                nonCovid,
                                confirmedCovid,
                                suspectedCovid,
                                updated_at,
                                published_on));
            }
        }
    }
}

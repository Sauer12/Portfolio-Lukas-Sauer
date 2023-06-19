package sk.tsystems.lzm.sourceAPI;

import org.json.JSONArray;
import org.json.JSONObject;
import sk.tsystems.lzm.entity.SlovakiaHospitalPatients;
import sk.tsystems.lzm.service.SlovakiaHospitalPatientsService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SlovakiaHospitalPatientsAPI {

    public void SlovakiaHospitalPatientsToDb(String responseBody, SlovakiaHospitalPatientsService slovakiaHospitalPatientsService){
        JSONObject slovakiaHospitalPatients = new JSONObject(responseBody);
        JSONArray arrayJson = slovakiaHospitalPatients.getJSONArray("page");
        SimpleDateFormat formatterDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat formatterDateOnly = new SimpleDateFormat("yyyy-MM-dd");

        if(slovakiaHospitalPatientsService.getSlovakiaHospitalPatients().isEmpty()){
            for(int i = 0; i < arrayJson.length(); i++){
                String oldestReportedAt = arrayJson.getJSONObject(i).getString("oldest_reported_at");
                String newestReportedAt = arrayJson.getJSONObject(i).getString("newest_reported_at");
                String publishedOn = arrayJson.getJSONObject(i).getString("published_on");
                long id = arrayJson.getJSONObject(i).getLong("id");
                int ventilatedCovid = arrayJson.getJSONObject(i).getInt("ventilated_covid");
                int nonCovid = arrayJson.getJSONObject(i).getInt("non_covid");
                int confirmedCovid = arrayJson.getJSONObject(i).getInt("confirmed_covid");
                int suspectedCovid = arrayJson.getJSONObject(i).getInt("suspected_covid");
                String updatedAt = arrayJson.getJSONObject(i).getString("updated_at");

                Date oldestReportedAtParsed = null;
                Date newestReportedAtParsed = null;
                Date publishedOnParsed = null;
                Date updatedAtParsed = null;
                try {
                    oldestReportedAtParsed = formatterDate.parse(oldestReportedAt);
                    newestReportedAtParsed = formatterDate.parse(newestReportedAt);
                    publishedOnParsed = formatterDateOnly.parse(publishedOn);
                    updatedAtParsed = formatterDate.parse(updatedAt);
                } catch (ParseException e) {
                    System.out.println(e.getMessage());
                }

                slovakiaHospitalPatientsService.addSlovakiaHospitalPatients(new SlovakiaHospitalPatients(id, oldestReportedAtParsed, newestReportedAtParsed,
                        publishedOnParsed, ventilatedCovid, nonCovid, confirmedCovid, suspectedCovid, updatedAtParsed));
            }
        }
    }

}

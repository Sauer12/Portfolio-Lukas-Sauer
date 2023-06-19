package sk.tsystems.lzm.sourceAPI;

import org.json.JSONArray;
import org.json.JSONObject;
import sk.tsystems.lzm.entity.RegionHospitalPatients;
import sk.tsystems.lzm.service.RegionHospitalPatientsService;
import sk.tsystems.lzm.service.RegionService;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class RegionHospitalPatientsAPI {

    public void regionHospitalPatientsToDb(String responseBody, RegionHospitalPatientsService regionHospitalPatientsService, RegionService regionService) {
        JSONObject regionHospitalPatients = new JSONObject(responseBody);
        JSONArray arrayJson = regionHospitalPatients.getJSONArray("page");
        SimpleDateFormat formatterDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat formatterDateOnly = new SimpleDateFormat("yyyy-MM-dd");

        if(regionHospitalPatientsService.getRegionHospitalPatients().isEmpty()) {
            for (int i = 0; i < arrayJson.length(); i++) {
                String oldestReportedAt = arrayJson.getJSONObject(i).getString("oldest_reported_at");
                String newestReportedAt = arrayJson.getJSONObject(i).getString("newest_reported_at");
                String publishedOn = arrayJson.getJSONObject(i).getString("published_on");
                int regionId = arrayJson.getJSONObject(i).getInt("region_id");
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

                System.out.println(oldestReportedAtParsed + " " + newestReportedAtParsed + " " +
                        regionId + " " + id + " " + ventilatedCovid + " " + nonCovid + " " +
                        confirmedCovid + " " + suspectedCovid + " " + updatedAtParsed + " " + publishedOnParsed);

                regionHospitalPatientsService.addRegionHospitalPatients(new RegionHospitalPatients(id, regionService.getRegions().get(regionId - 1), oldestReportedAtParsed,
                        newestReportedAtParsed, publishedOnParsed, ventilatedCovid, nonCovid, confirmedCovid, suspectedCovid, updatedAtParsed));
            }
        }
    }
}

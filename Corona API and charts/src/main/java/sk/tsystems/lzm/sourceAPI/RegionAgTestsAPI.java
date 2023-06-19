package sk.tsystems.lzm.sourceAPI;

import org.json.JSONArray;
import org.json.JSONObject;
import sk.tsystems.lzm.entity.RegionAgTests;
import sk.tsystems.lzm.service.RegionAgTestsService;
import sk.tsystems.lzm.service.RegionService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.format.DateTimeFormatter;

public class RegionAgTestsAPI {

    public void regionAgTestsToDb(String responseBody, RegionService regionService, RegionAgTestsService regionAgTestsService) {
        JSONObject regionAgTests = new JSONObject(responseBody);
        JSONArray arrayJson = regionAgTests.getJSONArray("page");
        SimpleDateFormat formatterDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat formatterDateOnly = new SimpleDateFormat("yyyy-MM-dd");
//        DateTimeFormatter formatterDateOnly = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        if(regionAgTestsService.getRegionAgTestsAll().isEmpty()) {
            for (int i = 0; i < arrayJson.length(); i++) {
                int regionId = arrayJson.getJSONObject(i).getInt("region_id");
                float positivityRate = arrayJson.getJSONObject(i).getFloat("positivity_rate");
                String id = arrayJson.getJSONObject(i).getString("id");
                String updatedAt = arrayJson.getJSONObject(i).getString("updated_at");
                String publishedOn = arrayJson.getJSONObject(i).getString("published_on");
                int positivesCount = arrayJson.getJSONObject(i).getInt("positives_count");
                int negativesCount = arrayJson.getJSONObject(i).getInt("negatives_count");
                int positivesSum = arrayJson.getJSONObject(i).getInt("positives_sum");
                int negativesSum = arrayJson.getJSONObject(i).getInt("negatives_sum");

                Date updatedAtParsed = null;
                Date publishedOnParsed = null;
                try {
                    updatedAtParsed = formatterDate.parse(updatedAt);
                    publishedOnParsed = formatterDateOnly.parse(publishedOn);
                } catch (ParseException e) {
                    System.out.println(e.getMessage());
                }

                regionAgTestsService.addRegionAgTests(new RegionAgTests(id, regionService.getRegions().get(regionId - 1), positivityRate,
                        updatedAtParsed, publishedOnParsed, positivesCount, negativesCount, positivesSum, negativesSum));
            }
        }
    }
}

package sk.tsystems.lzm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.json.JSONArray;
import org.json.JSONObject;
import sk.tsystems.lzm.service.DistrictAgTestsService;
import sk.tsystems.lzm.service.DistrictService;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DistrictAgTestsAPI {
    public void districtAgTestsToDb(String responseBody, DistrictAgTestsService districtAgTestsService, DistrictService districtService){
        JSONObject districtAgTests = new JSONObject(responseBody);
        JSONArray districtAgTestsList = districtAgTests.getJSONArray("page");
        SimpleDateFormat formatterDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat formatterDateOnly = new SimpleDateFormat("yyyy-MM-dd");

        if(districtAgTestsService.getDistrictAgTestsAll().isEmpty()) {
            for(int i = 0; i < districtAgTestsList.length(); i++) {
                districtAgTests = districtAgTestsList.getJSONObject(i);
                int districtId = districtAgTestsList.getJSONObject(i).getInt("district_id");
                Float positivityRate = districtAgTests.optFloat("positivity_rate");
                float positivityRateFloat = 0;
                if(positivityRate != null) {
                    positivityRateFloat = ((Float) positivityRate).floatValue();
                }
                String id = districtAgTestsList.getJSONObject(i).getString("id");
                String updatedAt = districtAgTestsList.getJSONObject(i).getString("updated_at");
                String publishedOn = districtAgTestsList.getJSONObject(i).getString("published_on");
                int positivesCount = districtAgTestsList.getJSONObject(i).getInt("positives_count");
                int negativesCount = districtAgTestsList.getJSONObject(i).getInt("negatives_count");
                int positivesSum = districtAgTestsList.getJSONObject(i).getInt("positives_sum");
                int negativesSum = districtAgTestsList.getJSONObject(i).getInt("negatives_sum");

                java.util.Date updatedAtParsed = null;
                java.util.Date publishedOnParsed = null;
                try {
                    updatedAtParsed = formatterDate.parse(updatedAt);
                    publishedOnParsed = formatterDateOnly.parse(publishedOn);
                } catch (ParseException e) {
                    System.out.println(e.getMessage());
                }

                System.out.println(positivityRateFloat);

                districtAgTestsService.addDistrictAgTests(new DistrictAgTests(id, districtService.getDistricts().get(districtId - 1), positivityRateFloat,
                        updatedAtParsed, publishedOnParsed, positivesCount, negativesCount, positivesSum, negativesSum));
            }
        }
    }
}
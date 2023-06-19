/*package sk.tsystems.lzm.sourceAPI;

import org.json.JSONArray;
import org.json.JSONObject;
import sk.tsystems.lzm.entity.SlovakiaAgTests;
import sk.tsystems.lzm.service.SlovakiaAgTestsService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SlovakiaAgTestsAPIUpdate {
    public void slovakiaAgTestsToDb(String responseBody, SlovakiaAgTestsService slovakiaAgTestsService){

        JSONObject slovakiaAgTests = new JSONObject(responseBody);
        JSONArray slovakiaAgTestsList = slovakiaAgTests.getJSONArray("page");

        Long apiUrlLastId = Long.parseLong(slovakiaAgTestsList.getJSONObject(0).getString("id"));
        Long dbLastId = Long.parseLong(slovakiaAgTestsService.getLastId());

        if(dbLastId < apiUrlLastId){
            slovakiaAgTestsService.reset();
        }*/

        /*for(int i = 0; i < slovakiaAgTestsList.length(); i++) {
            slovakiaAgTests = slovakiaAgTestsList.getJSONObject(i);
            String id = slovakiaAgTestsList.getJSONObject(i).getString("id");
            Float positivityRate = slovakiaAgTests.optFloat("positivity_rate");
            float positivityRateFloat = 0;
            if(positivityRate != null) {
                positivityRateFloat = ((Float)positivityRate).floatValue();
            }
            int positivesCount = slovakiaAgTestsList.getJSONObject(i).getInt("positives_count");
            int negativesCount = slovakiaAgTestsList.getJSONObject(i).getInt("negatives_count");
            int positivesSum = slovakiaAgTestsList.getJSONObject(i).getInt("positives_sum");
            int negativesSum = slovakiaAgTestsList.getJSONObject(i).getInt("negatives_sum");
            String updatedAt = slovakiaAgTestsList.getJSONObject(i).getString("updated_at");
            String publishedOn = slovakiaAgTestsList.getJSONObject(i).getString("published_on");

            Date updatedAtParsed = null;
            Date publishedOnParsed = null;
            try {
                updatedAtParsed = formatterDate.parse(updatedAt);
                publishedOnParsed = formatterDateOnly.parse(publishedOn);
            } catch (ParseException e) {
                System.out.println(e.getMessage());
            }
            slovakiaAgTestsService.addSlovakiaAgTests(new SlovakiaAgTests(id, positivityRateFloat, updatedAtParsed, publishedOnParsed, positivesCount, negativesCount, positivesSum, negativesSum));
        }*/
/*    }
}*/

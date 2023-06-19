package sk.tsystems.lzm.sourceAPI;

import org.json.JSONArray;
import org.json.JSONObject;
import sk.tsystems.lzm.entity.HospitalBeds;
import sk.tsystems.lzm.entity.SlovakiaHospitalBeds;
import sk.tsystems.lzm.service.HospitalBedsService;
import sk.tsystems.lzm.service.HospitalService;
import sk.tsystems.lzm.service.SlovakiaHospitalBedsService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HospitalBedsAPI {

    public void hospitalBedsAPIToDb(String responseBody, HospitalBedsService hospitalBedsService, HospitalService hospitalService) throws ParseException {

        JSONObject hospitalBeds = new JSONObject(responseBody);
        JSONArray arrayJson = hospitalBeds.getJSONArray("page");

        if(hospitalBedsService.getAllHospitalBeds().isEmpty()) {
            for(int i = 0; i < arrayJson.length(); i++) {

                int hospitalId = arrayJson.getJSONObject(i).getInt("hospital_id");
                long id = arrayJson.getJSONObject(i).getLong("id");

                String reportedAt =  arrayJson.getJSONObject(i).getString("reported_at");
                String updatedAt = arrayJson.getJSONObject(i).getString("updated_at");

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date reported_at = sdf.parse(reportedAt);
                Date updated_at = sdf.parse(updatedAt);

                String publishedOn = arrayJson.getJSONObject(i).getString("published_on");
                SimpleDateFormat othersdf = new SimpleDateFormat("yyyy-MM-dd");
                Date published_on = othersdf.parse(publishedOn);

                int capacityAll = arrayJson.getJSONObject(i).getInt("capacity_all");
                int freeAll = arrayJson.getJSONObject(i).getInt("free_all");
                int capacityCovid = arrayJson.getJSONObject(i).getInt("capacity_covid");
                int occupiedJisCovid = arrayJson.getJSONObject(i).getInt("occupied_jis_covid");
                int occupiedOaimCovid = arrayJson.getJSONObject(i).getInt("occupied_oaim_covid");
                int occupiedO2Covid = arrayJson.getJSONObject(i).getInt("occupied_o2_covid");
                int occupiedOtherCovid = arrayJson.getJSONObject(i).getInt("occupied_other_covid");

                hospitalBedsService.addHospitalBeds(
                        new HospitalBeds(
                                id,
                                hospitalService.getHospital(hospitalId),
                                reported_at,
                                updated_at,
                                published_on,
                                capacityAll,
                                freeAll,
                                capacityCovid,
                                occupiedJisCovid,
                                occupiedOaimCovid,
                                occupiedO2Covid,
                                occupiedOtherCovid));
            }
        }
    }

//    public void hospitalBedsAPIToDb(String responseBody, HospitalBedsService hospitalBedsService, HospitalService hospitalService) throws ParseException {
//
//        JSONObject hospitalBeds = new JSONObject(responseBody);
//        JSONArray arrayJson = hospitalBeds.getJSONArray("page");
//
//        if(hospitalBedsService.getAllHospitalBeds().isEmpty()) {
//            for(int i = 0; i < arrayJson.length(); i++) {
//                hospitalBeds = arrayJson.getJSONObject(i);
//
//                int hospitalId = hospitalBeds.getInt("hospital_id");
//                long id = hospitalBeds.getLong("id");
//                String reportedAt =  hospitalBeds.getString("reported_at");
//                String updatedAt = hospitalBeds.getString("updated_at");
//                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                Date reported_at = sdf.parse(reportedAt);
//                Date updated_at = sdf.parse(updatedAt);
//                String publishedOn = hospitalBeds.getString("published_on");
//                SimpleDateFormat othersdf = new SimpleDateFormat("yyyy-MM-dd");
//                Date published_on = othersdf.parse(publishedOn);
//
//                int capacityAll = hospitalBeds.getInt("capacity_all");
//                int freeAll = hospitalBeds.getInt("free_all");
//                int capacityCovid = hospitalBeds.getInt("capacity_covid");
//                int occupiedJisCovid = hospitalBeds.getInt("occupied_jis_covid");
//                int occupiedOaimCovid = hospitalBeds.getInt("occupied_oaim_covid");
//                int occupiedO2Covid = hospitalBeds.getInt("occupied_o2_covid");
//                int occupiedOtherCovid = hospitalBeds.getInt("occupied_other_covid");
//
//                hospitalBedsService.addHospitalBeds(new HospitalBeds(id, hospitalService.getHospitals().get(hospitalId-1), reported_at, updated_at, published_on, capacityAll, freeAll, capacityCovid, occupiedJisCovid, occupiedOaimCovid, occupiedO2Covid, occupiedOtherCovid));
//            }
//        }
//    }
}

package sk.tsystems.lzm.sourceAPI;

import org.json.JSONArray;
import org.json.JSONObject;
import sk.tsystems.lzm.entity.HospitalStaff;
import sk.tsystems.lzm.service.HospitalService;
import sk.tsystems.lzm.service.HospitalStaffService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HospitalStaffAPI {

    public void hospitalStaffToDb(String responseBody, HospitalStaffService hospitalStaffService, HospitalService hospitalService) {
        JSONObject hospitalStaff = new JSONObject(responseBody);
        JSONArray hospitalStaffList = hospitalStaff.getJSONArray("page");
        SimpleDateFormat formatterDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat formatterDateOnly = new SimpleDateFormat("yyyy-MM-dd");
        if(hospitalStaffService.getHospitalStaff().isEmpty()) {
            for (int i = 0; i < hospitalStaffList.length(); i++) {
                int hospitalId = hospitalStaffList.getJSONObject(i).getInt("hospital_id");
                long id = hospitalStaffList.getJSONObject(i).getLong("id");

                float outOfWorkRatioDoctor = hospitalStaffList.getJSONObject(i).getFloat("out_of_work_ratio_doctor");
                float outOfWorkRatioNurse = hospitalStaffList.getJSONObject(i).getFloat("out_of_work_ratio_nurse");
                float outOfWorkRatioOther = hospitalStaffList.getJSONObject(i).getFloat("out_of_work_ratio_other");

                String updatedAt = hospitalStaffList.getJSONObject(i).getString("updated_at");
                String publishedOn = hospitalStaffList.getJSONObject(i).getString("published_on");

                java.util.Date updatedAtParsed = null;
                java.util.Date publishedOnParsed = null;
                try {
                    updatedAtParsed = formatterDate.parse(updatedAt);
                    publishedOnParsed = formatterDateOnly.parse(publishedOn);
                } catch (ParseException e) {
                    System.out.println(e.getMessage());
                    ;
                }

                hospitalStaffService.addHospitalStaff(new HospitalStaff(id, hospitalService.getHospital(hospitalId), outOfWorkRatioDoctor, outOfWorkRatioNurse, outOfWorkRatioOther,
                        updatedAtParsed, publishedOnParsed));

            }
        }
    }

    /*public void hospitalStaffToDb(String responseBody, HospitalService hospitalService, HospitalStaffService hospitalStaffService){
        JSONObject hospitalStaff = new JSONObject(responseBody);
        JSONArray arrayJson = hospitalStaff.getJSONArray("page");
        SimpleDateFormat formatterDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat formatterDateOnly = new SimpleDateFormat("yyyy-MM-dd");

        if(hospitalStaffService.getHospitalStaff().isEmpty()){
            for(int i = 0; i < arrayJson.length(); i++){
                hospitalStaff = arrayJson.getJSONObject(i);
                int hospitalId = hospitalStaff.getInt("hospital_id");
                long id = hospitalStaff.getLong("id");
                String reportedAt = hospitalStaff.getString("reported_at");
                float outOfWorkRatioDoctor = hospitalStaff.getFloat("out_of_work_ratio_doctor");
                float outOfWorkRatioNurse = hospitalStaff.getFloat("out_of_work_ratio_nurse");
                float outOfWorkRatioOther = hospitalStaff.getFloat("out_of_work_ratio_other");
                String updatedAt = hospitalStaff.getString("updated_at");
                String publishedOn = hospitalStaff.getString("published_on");

                Date updatedAtParsed = null;
                Date publishedOnParsed = null;
                try {
                    updatedAtParsed = formatterDate.parse(updatedAt);
                    publishedOnParsed = formatterDateOnly.parse(publishedOn);
                } catch (ParseException e) {
                    System.out.println(e.getMessage());
                }

                hospitalStaffService.addHospitalStaffService(new HospitalStaff(id, hospitalService.getHospital(hospitalId - 1),
                        outOfWorkRatioDoctor, outOfWorkRatioNurse, outOfWorkRatioOther, updatedAtParsed, publishedOnParsed));
            }
        }
    }*/
}

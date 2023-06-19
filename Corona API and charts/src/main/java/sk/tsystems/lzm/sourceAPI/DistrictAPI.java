package sk.tsystems.lzm.sourceAPI;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import sk.tsystems.lzm.entity.District;
import sk.tsystems.lzm.entity.Region;
import sk.tsystems.lzm.service.DistrictService;
import sk.tsystems.lzm.service.RegionService;

import javax.transaction.Transactional;

public class DistrictAPI {

    public void districtToDb(String responseBody, DistrictService districtService, RegionService regionService){
        JSONArray districts = new JSONArray(responseBody);
        if(districtService.getDistricts().isEmpty()) {
            for(int i = 0; i < districts.length(); i++) {
                JSONObject district = districts.getJSONObject(i);
                int regionId = district.getInt("region_id");
                int id = district.getInt("id");
                String title = district.getString("title");
                String code = district.getString("code");
//              -1 tu je preto, lebo indexy v getRegions zacinaju od 0, takze stale musime dat -1
                districtService.addDistrict(new District(id, regionService.getRegions().get(regionId - 1), title, code));
            }
        }
    }
}

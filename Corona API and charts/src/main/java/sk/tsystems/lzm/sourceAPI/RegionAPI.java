package sk.tsystems.lzm.sourceAPI;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import sk.tsystems.lzm.entity.Region;
import sk.tsystems.lzm.service.RegionService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

public class RegionAPI{
    public void regionToDb(String responseBody, RegionService regionService){
        JSONArray regions = new JSONArray(responseBody);
        if(regionService.getRegions().isEmpty()) {
            for (int i = 0; i < regions.length(); i++) {
                JSONObject region = regions.getJSONObject(i);
                int id = region.getInt("id");
                String title = region.getString("title");
                String code = region.getString("code");
                String abbreviation = region.getString("abbreviation");
                regionService.addRegion(new Region(id, title, code, abbreviation));
            }
        }
    }
}

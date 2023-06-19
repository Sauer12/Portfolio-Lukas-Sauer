package sk.tsystems.lzm.server;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import sk.tsystems.lzm.entity.Vaccine;
import sk.tsystems.lzm.service.VaccineService;
import sk.tsystems.lzm.service.VaccineServiceJPA;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class JsonDbLoader {


    private static HttpURLConnection connection;

    public static void loadAndSaveDataFromApi(String apiUrl){
        BufferedReader reader;
        String line;
        StringBuffer responseContent = new StringBuffer();
        try {
            URL url = new URL(apiUrl);
            connection = (HttpURLConnection) url.openConnection();

            //Request setup
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            //200 - uspesne pripojenie
            int status = connection.getResponseCode();
//            System.out.println(status);
            if (status > 299){
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = reader.readLine()) != null){
                    responseContent.append(line);
                }
                reader.close();
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null){
                    responseContent.append(line);
                }
                reader.close();
            }
//            System.out.println(responseContent.toString());
            parse(responseContent.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }
    }

    private static void parse(String responseBody){
        JSONArray vaccines = new JSONArray(responseBody);
        for(int i = 0; i < vaccines.length(); i++){
            JSONObject vaccine = vaccines.getJSONObject(i);
            int id = vaccine.getInt("id");
            String title = vaccine.getString("title");
            String manufacturer = vaccine.getString("manufacturer");
//            vaccineService.addVaccine(new Vaccine(id, title, manufacturer));
        }
    }
}

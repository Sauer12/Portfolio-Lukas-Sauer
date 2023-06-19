package sk.tsystems.lzm;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import sk.tsystems.lzm.entity.*;
import sk.tsystems.lzm.entity.DistrictAgTestsAPI;
import sk.tsystems.lzm.service.*;
import sk.tsystems.lzm.sourceAPI.*;
import sk.tsystems.lzm.sourceAPI.RegionAPI;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.ParseException;
import java.util.List;

public class App {
    private HttpURLConnection connection;
    @Autowired
    private VaccineService vaccineService;
    @Autowired
    private RegionService regionService;
    @Autowired
    private DistrictService districtService;
    @Autowired
    private CityService cityService;
    @Autowired
    private HospitalService hospitalService;
    @Autowired
    private HospitalBedsService hospitalBedsService;
    @Autowired
    private DistrictHospitalBedsService districtHospitalBedsService;
    @Autowired
    private RegionHospitalBedsService regionHospitalBedsService;
    @Autowired
    private SlovakiaHospitalBedsService slovakiaHospitalBedsService;
    @Autowired
    private HospitalPatientsService hospitalPatientsService;
    @Autowired
    private DistrictHospitalPatientsService districtHospitalPatientsService;
    @Autowired
    private RegionHospitalPatientsService regionHospitalPatientsService;
    @Autowired
    private SlovakiaHospitalPatientsService slovakiaHospitalPatientsService;
    @Autowired
    private HospitalStaffService hospitalStaffService;
    @Autowired
    private VaccinationsService vaccinationsService;
    @Autowired
    private RegionVaccinationsService regionVaccinationsService;
    @Autowired
    private SlovakiaVaccinationsService slovakiaVaccinationsService;
    @Autowired
    private DistrictAgTestsService districtAgTestsService;
    @Autowired
    private RegionAgTestsService regionAgTestsService;
//    @Autowired
//    public SlovakiaAgTestsService slovakiaAgTestsService;


/*
    public void run(){
//      Natahovanie dat do databazy z api -> zdroj sourceAPI classes
//      Entity
        loadAndSaveDataFromApi("https://data.korona.gov.sk/api/vaccines","vaccines");
        loadAndSaveDataFromApi("https://data.korona.gov.sk/api/regions","regions");
        loadAndSaveDataFromApi("https://data.korona.gov.sk/api/districts","districts");
        loadAndSaveDataFromApi("https://data.korona.gov.sk/api/cities","cities");
        loadAndSaveDataFromApi("https://data.korona.gov.sk/api/hospitals","hospitals");
//      Lozka
        loadAndSaveDataFromApi("https://data.korona.gov.sk/api/hospital-beds", "hospitalBeds");
        loadAndSaveDataFromApi("https://data.korona.gov.sk/api/hospital-beds/by-district", "districtHospitalBeds");
        loadAndSaveDataFromApi("https://data.korona.gov.sk/api/hospital-beds/by-region", "regionHospitalBeds");
        loadAndSaveDataFromApi("https://data.korona.gov.sk/api/hospital-beds/in-slovakia", "slovakiaHospitalBeds");

//      Pacienti
        loadAndSaveDataFromApi("https://data.korona.gov.sk/api/hospital-patients", "hospitalPatients");
        loadAndSaveDataFromApi("https://data.korona.gov.sk/api/hospital-patients/by-district", "districtHospitalPatients");
        loadAndSaveDataFromApi("https://data.korona.gov.sk/api/hospital-patients/by-region","regionHospitalPatients");
        loadAndSaveDataFromApi("https://data.korona.gov.sk/api/hospital-patients/in-slovakia","slovakiaHospitalPatients");

//      Zdravotnicky personal
        loadAndSaveDataFromApi("https://data.korona.gov.sk/api/hospital-staff", "hospitalStaff");

//      Vakcinacie
        loadAndSaveDataFromApi("https://data.korona.gov.sk/api/vaccinations", "vaccinations");
        loadAndSaveDataFromApi("https://data.korona.gov.sk/api/vaccinations/by-region", "regionVaccinations");
        loadAndSaveDataFromApi("https://data.korona.gov.sk/api/vaccinations/in-slovakia", "slovakiaVaccinations");

//      Ag testy
        loadAndSaveDataFromApi("https://data.korona.gov.sk/api/ag-tests/by-district", "districtAgTests");
        loadAndSaveDataFromApi("https://data.korona.gov.sk/api/ag-tests/by-region", "regionAgTests");
        loadAndSaveDataFromApi("https://data.korona.gov.sk/api/ag-tests/in-slovakia", "slovakiaAgTests");
    }
*/

    public StringBuffer loadResponse(String apiUrl) {
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
            if (status > 299) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                responseContent.append(" error!");
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
            }
            reader.close();
            return responseContent;
        } catch (ProtocolException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

/*    public void loadAndSaveDataFromApi(String apiUrl, String apiName, SlovakiaAgTestsService slovakiaAgTestsService){
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

//          Volanie jednotlivych API metod pre parsovanie a ulozenie dat z API do db, predavanie dat/raw Jsonu a services do parametru
            switch(apiName){
//              entity
                case "vaccines":
                    VaccineAPI vaccineAPI = new VaccineAPI();
                    vaccineAPI.vaccineToDb(responseContent.toString(), vaccineService);
                    break;
                case "regions":
                    RegionAPI regionAPI = new RegionAPI();
                    regionAPI.regionToDb(responseContent.toString(), regionService);
                    break;
                case "districts":
                    DistrictAPI districtAPI = new DistrictAPI();
                    districtAPI.districtToDb(responseContent.toString(), districtService, regionService);
                    break;
                case "cities":
                    CityAPI cityAPI = new CityAPI();
                    cityAPI.cityToDb(responseContent.toString(),cityService, districtService);
                    break;
                case "hospitals":
                    HospitalAPI hospitalAPI = new HospitalAPI();
                    hospitalAPI.hospitalToDb(responseContent.toString(), hospitalService, cityService);
                    break;
//              lozka
                case "hospitalBeds":
                    HospitalBedsAPI hospitalBedsAPI = new HospitalBedsAPI();
                    hospitalBedsAPI.hospitalBedsAPIToDb(responseContent.toString(), hospitalBedsService, hospitalService);
                    break;
                case "districtHospitalBeds":
                    DistrictHospitalBedsAPI districtHospitalBedsAPI = new DistrictHospitalBedsAPI();
                    districtHospitalBedsAPI.districtHospitalBedsToDb(responseContent.toString(), districtHospitalBedsService, districtService);
                    break;
                case "regionHospitalBeds":
                    RegionHospitalBedsAPI regionHospitalBedsAPI = new RegionHospitalBedsAPI();
                    regionHospitalBedsAPI.regionHospitalBedsToDb(responseContent.toString(), regionHospitalBedsService, regionService);
                    break;
                case "slovakiaHospitalBeds":
                    SlovakiaHospitalBedsAPI slovakiaHospitalBedsAPI = new SlovakiaHospitalBedsAPI();
                    slovakiaHospitalBedsAPI.slovakiaHospitalBedsToDb(responseContent.toString(), slovakiaHospitalBedsService);
                    break;
//              pacienti
                case "hospitalPatients":
                    HospitalPatientsAPI hospitalPatientsAPI = new HospitalPatientsAPI();
                    hospitalPatientsAPI.hospitalPatientsToDb(responseContent.toString(), hospitalPatientsService, hospitalService);
                    break;
                case "districtHospitalPatients":
                    DistrictHospitalPatientsAPI districtHospitalPatientsAPI = new DistrictHospitalPatientsAPI();
                    districtHospitalPatientsAPI.districtHospitalPatientsToDb(responseContent.toString(),districtHospitalPatientsService, districtService);
                    break;
                case "regionHospitalPatients":
                    RegionHospitalPatientsAPI regionHospitalPatientsAPI = new RegionHospitalPatientsAPI();
                    regionHospitalPatientsAPI.regionHospitalPatientsToDb(responseContent.toString(), regionHospitalPatientsService, regionService);
                    break;
                case "slovakiaHospitalPatients":
                    SlovakiaHospitalPatientsAPI slovakiaHospitalPatientsAPI = new SlovakiaHospitalPatientsAPI();
                    slovakiaHospitalPatientsAPI.SlovakiaHospitalPatientsToDb(responseContent.toString(), slovakiaHospitalPatientsService);
                    break;
//              Zdravotnicky personal
                case "hospitalStaff":
                    HospitalStaffAPI hospitalStaffAPI = new HospitalStaffAPI();
                    hospitalStaffAPI.hospitalStaffToDb(responseContent.toString(), hospitalStaffService, hospitalService);
                    break;
//              vakcinacie
                case "vaccinations":
                    VaccinationsAPI vaccinationsAPI = new VaccinationsAPI();
                    vaccinationsAPI.vaccinationsToDb(responseContent.toString(), vaccineService, regionService, vaccinationsService);
                    break;
                case "regionVaccinations":
                    RegionVaccinationsAPI regionVaccinationsAPI = new RegionVaccinationsAPI();
                    regionVaccinationsAPI.regionVaccinationsToDb(responseContent.toString(), regionVaccinationsService, regionService);
                    break;
                case "slovakiaVaccinations":
                    SlovakiaVaccinationsAPI slovakiaVaccinationsAPI = new SlovakiaVaccinationsAPI();
                    slovakiaVaccinationsAPI.slovakiaVaccinationsToDb(responseContent.toString(), slovakiaVaccinationsService);
                    break;
//              ag testy
                case "districtAgTests":
                    DistrictAgTestsAPI districtAgTestsAPI = new DistrictAgTestsAPI();
                    districtAgTestsAPI.districtAgTestsToDb(responseContent.toString(), districtAgTestsService, districtService);
                    break;
                case "regionAgTests":
                    RegionAgTestsAPI regionAgTestsAPI = new RegionAgTestsAPI();
                    regionAgTestsAPI.regionAgTestsToDb(responseContent.toString(), regionService, regionAgTestsService);
                    break;

            }

        } catch (MalformedURLException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } finally {
            connection.disconnect();
        }
    }*/

    public void loadSlovakiaAgTestsAPI(String responseContent, SlovakiaAgTestsService slovakiaAgTestsService){
        SlovakiaAgTestsAPI slovakiaAgTestsAPI = new SlovakiaAgTestsAPI();
        slovakiaAgTestsAPI.slovakiaAgTestsToDb(responseContent, slovakiaAgTestsService);
    }
}


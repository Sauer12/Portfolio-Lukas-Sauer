package sk.tsystems.lzm.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import sk.tsystems.lzm.service.*;

@SpringBootApplication
@EntityScan(basePackages = "sk.tsystems.lzm.entity")
public class Server {
    public static void main(String[] args) {
        SpringApplication.run(Server.class);
    }
    //  Entity
    @Bean
    public VaccineService vaccineService() {
        return new VaccineServiceJPA();
    }
    @Bean
    public RegionService regionService(){
        return new RegionServiceJPA();
    }
    @Bean
    public DistrictService districtService() {
        return new DistrictServiceJPA();
    }
    @Bean
    public CityService cityService(){
        return new CityServiceJPA();
    }
    @Bean
    public HospitalService hospitalService(){
        return new HospitalServiceJPA();
    }

    //  Lozka
    @Bean
    public HospitalBedsService hospitalBedsService() {return new HospitalBedsServiceJPA();}
    @Bean
    public DistrictHospitalBedsService districtHospitalBedsService(){return new DistrictHospitalBedsServiceJPA();}
    @Bean
    public RegionHospitalBedsService regionHospitalBedsService(){return new RegionHospitalBedsServiceJPA();}
    @Bean
    public SlovakiaHospitalBedsService slovakiaHospitalBedsService(){return new SlovakiaHospitalBedsServiceJPA();}
    //  Pacienti
    @Bean
    public HospitalPatientsService hospitalPatientsService(){return new HospitalPatientsServiceJPA();}
    @Bean
    public DistrictHospitalPatientsService districtHospitalPatientsService(){return new DistrictHospitalPatientsServiceJPA();}
    @Bean
    public RegionHospitalPatientsService regionHospitalPatientsService() {
        return new RegionHospitalPatientsServiceJPA();
    }
    @Bean
    public SlovakiaHospitalPatientsService slovakiaHospitalPatientsService(){
        return new SlovakiaHospitalPatientsServiceJPA();
    }

    //  Zdravotnicky personal
    @Bean
    public HospitalStaffService hospitalStaffService(){
        return new HospitalStaffServiceJPA();
    }
    //  Vakcinacie
    @Bean
    public VaccinationsService vaccinationsService(){
        return new VaccinationsServiceJPA();
    }
    @Bean
    public RegionVaccinationsService regionVaccinationsService() {return new RegionVaccinationsServiceJPA();}
    @Bean
    public SlovakiaVaccinationsService slovakiaVaccinationsService(){return new SlovakiaVaccinationsServiceJPA();}
    @Bean
    public VaccinationContactsService vaccinationContactsService(){
        return new VaccinationContactsServiceJPA();
    }
    //  Ag testy
    @Bean
    public DistrictAgTestsService districtAgTestsService() {return new DistrictAgTestsServiceJPA();}
    @Bean
    public RegionAgTestsService regionAgTestsService() {
        return new RegionAgTestsServiceJPA();
    }
    @Bean
    public SlovakiaAgTestsService slovakiaAgTestsService() {return new SlovakiaAgTestsServiceJPA();}
}

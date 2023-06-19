package sk.tsystems.lzm;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import sk.tsystems.lzm.entity.SlovakiaVaccinations;
import sk.tsystems.lzm.entity.Vaccinations;
import sk.tsystems.lzm.service.*;
import sk.tsystems.lzm.sourceAPI.SlovakiaAgTestsAPI;

@SpringBootApplication
@ComponentScan(excludeFilters = @ComponentScan.Filter(type= FilterType.REGEX, pattern = "sk.tsystems.lzm.server.*"))
public class SpringClient {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringClient.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }

/*    @Bean
    public CommandLineRunner runnerApp(App app){
        return args -> {
            app.run();
        };
    }*/
    @Bean
    public App app(){
        return new App();
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

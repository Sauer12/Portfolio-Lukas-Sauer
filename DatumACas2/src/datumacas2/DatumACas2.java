/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datumacas2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Luxy
 */
public class DatumACas2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LocalDate hallowen = LocalDate.of(2021, Month.OCTOBER, 31);
        System.out.println("Rok: " + hallowen.getYear() + ", mesiac: " + hallowen.getMonthValue() + ", den " + hallowen.getDayOfMonth());
        
        LocalDateTime datumCas = LocalDateTime.parse("2016-12-08T10:20:30");
        LocalDate datum = LocalDate.parse("2016-12-08");
        LocalTime cas = LocalTime.parse("10:20:30");
        
        System.out.println(datumCas.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
        System.out.println(datum.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
        System.out.println(cas.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM)));
        
        LocalDateTime datumCas2 = LocalDateTime.parse("12/08/2016 10:20:30", DateTimeFormatter.ofPattern("M/d/y HH:mm:ss"));
        LocalDate datum2 = LocalDate.parse("12/8/2016", DateTimeFormatter.ofPattern("M/d/y"));
        LocalTime cas2 = LocalTime.parse("10:20:30", DateTimeFormatter.ofPattern("H:m:ss"));
        
        System.out.println(datumCas.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
        System.out.println(datumCas.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
        System.out.println(cas.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM)));
        
        LocalDate halloween = LocalDate.of(2020, 10, 31);
        LocalDate vianoce = LocalDate.of(2020, 12, 24);
        System.out.println("po: " + halloween.isAfter(vianoce));
        System.out.println("pred: " + halloween.isBefore(vianoce));
        System.out.println("zhodny: " + halloween.equals(vianoce));
        System.out.println("zhodny " + vianoce.equals(halloween));
        System.out.println("prestupny: " + halloween.isLeapYear());
        System.out.println("prestupny: " + vianoce.isLeapYear());
        System.out.println("Podporuje hodiny: " + halloween.isSupported(ChronoUnit.HOURS));
        System.out.println("Podporuje roky: " + halloween.isSupported(ChronoUnit.YEARS));
        
        ZonedDateTime lokalnyDatumCas = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println(lokalnyDatumCas);
        
        
    }
     
}

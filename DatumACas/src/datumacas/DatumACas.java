/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datumacas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;

/**
 *
 *
 * @author Luxy
 */
public class DatumACas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Datum a čas
        LocalDateTime datumCas = LocalDateTime.of(2021, Month.FEBRUARY, 25, 18, 50);
        System.out.println(datumCas);
        
        // iba dátum
        LocalDate datum = LocalDate.of(2020, Month.FEBRUARY, 25);
        System.out.println(datum);
        
        //iba čas
        LocalTime cas = LocalTime.of(18, 55, 25);
        System.out.println(cas);
        
        //Aktualný datum a čas
        LocalDateTime datumCas2 = LocalDateTime.now();
        System.out.println(datumCas2);
        
        //Aktualný datum
        LocalDate datum2 = LocalDate.now();
        System.out.println(datum2);
        
        //Aktualný čas
        LocalTime cas2 = LocalTime.now();
        System.out.println(cas2);
        
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM)));
        System.out.println(dateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
        System.out.println(dateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG, FormatStyle.SHORT)));
        
        LocalDate zaciatok = LocalDate.of(1939, 9, 1);
        LocalDateTime datumCas3 = LocalDateTime.of(zaciatok, LocalTime.of(10, 0));
        System.out.println(datumCas3);
        
        LocalDateTime datumCas4 = zaciatok.atStartOfDay();
        System.out.println(datumCas4);
        LocalDateTime datumCas5 = zaciatok.atTime(5, 0);
        System.out.println(datumCas5);
        
        LocalDateTime datumCas6 = LocalDateTime.now();
        datumCas6 = datumCas.plusDays(4);
        System.out.println(datumCas.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
        
        LocalDateTime datumCas7 = LocalDateTime.now();
        datumCas7 = datumCas.plus(Period.ofDays(3));
        System.out.println(datumCas7.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
        
        LocalDateTime datumCas8 = LocalDateTime.now();
        datumCas8 = datumCas8.plus(3, ChronoUnit.DAYS);
        System.out.println(datumCas8.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
        
        LocalDate zaciatok2 = LocalDate.of(1939, 9, 1);
        LocalDate koniec = LocalDate.of(1945, 9, 2);
        TemporalAmount doba = Period.between(zaciatok2, koniec);
        
        
        System.out.println("II. svetová vojna trvala " + doba.get(ChronoUnit.YEARS) + " rokov a " + doba.get(ChronoUnit.DAYS) + " dní.");
        
        LocalDate zaciatok3 = LocalDate.of(1939, 9, 1);
        LocalDate koniec3 = LocalDate.of(1945, 9, 2);
        
        Period dobax = zaciatok3.until(koniec);
        Period dobay = Period.between(zaciatok3, koniec3);
        
        System.out.println(dobay);
    }
    
    
}

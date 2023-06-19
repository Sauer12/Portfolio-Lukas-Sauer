/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dateandtime;

import java.time.Month;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
/**
 *
 * @author Luxy
 */
public class DateAndTime {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
     /*   LocalDateTime datumCas = LocalDateTime.of(2016, Month.APRIL, 15, 3, 15);
        System.out.println(datumCas);
        
        LocalDate datum = LocalDate.of(2016,Month.FEBRUARY, 25);
        System.out.println(datum);
        
        LocalTime cas = LocalTime.of(3,15,10);
        System.out.println(cas);
        
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);
        
        LocalDate date = LocalDate.now();
        System.out.println(date);
        
        LocalTime time = LocalTime.now();
        System.out.println(time);*/
     
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
        System.out.println(dateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
        System.out.println(dateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG, FormatStyle.SHORT)));
        System.out.println(dateTime.format(DateTimeFormatter.ofPattern("d.M.y H:m:ss")));
        
        LocalDate zaciatok = LocalDate.of(1939, 9, 1);
        LocalDateTime datumCas = LocalDateTime.now();
        LocalDateTime datumCas2 = zaciatok.atTime(0,0);
        datumCas = datumCas.plusDays(3);
        
        System.out.println(datumCas.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
        
    }
    
}

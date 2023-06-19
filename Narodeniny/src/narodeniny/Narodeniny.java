/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package narodeniny;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;

/**
 *
 * @author Luxy
 */
public class Narodeniny {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "Windows-1250");
       
        System.out.println("Zadaj datum narodenia:");
        LocalDate narodeniny = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("d.M.y"));
        LocalDate dnesnyDen = LocalDate.now();
        TemporalAmount doba = Period.between(narodeniny, dnesnyDen);
        int pocetDni = 0;
        
        if(narodeniny.getDayOfYear() >= dnesnyDen.getDayOfYear()) {         
            pocetDni = narodeniny.getDayOfYear() - dnesnyDen.getDayOfYear();
        }
           
        
        System.out.printf("Je ti %d rokov a narodeniny máš za %d dni", doba.get(ChronoUnit.YEARS), pocetDni);
    }
    
}

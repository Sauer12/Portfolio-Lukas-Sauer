/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piatoktrinasteho;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author Luxy
 */
public class PiatokTrinasteho {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "Windows-1250");
        System.out.println("Pre zadaný interval dátumov vypíše všetky piatky 13.:");
        System.out.println("Zadajte 1. dátum");
        LocalDate datum1 = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("d.M.y"));
        System.out.println("Zadajte 2. dátum");
        LocalDate datum2 = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("d.M.y"));
        System.out.println("Piatky 13.:");
        
        while(!(datum1.isEqual(datum2))) {
            if(datum1.getDayOfMonth() == 13 && (datum1.getDayOfWeek() == DayOfWeek.FRIDAY)) {
                System.out.print(datum1.format(DateTimeFormatter.ofPattern("d.M.y, ")));
            }
            datum1 = datum1.plusDays(1);
        }        
    }
    
}

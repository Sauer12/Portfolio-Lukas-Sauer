/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopkalkulacka;

import java.util.Scanner;
/**
 *
 * @author Luxy
 */
public class OOPkalkulacka {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "Windows-1250");
        Kalkulacka kalkulacka = new Kalkulacka();
        float cisloA = 0;
        float cisloB = 0;
        String pokracovat = "ano";
        int volba = 0;
        
        while(pokracovat.equals("ano")){
            System.out.println("Vyber si moznost:");
            System.out.println("1 - Scitanie");
            System.out.println("2 - Odcitanie");
            System.out.println("3 - Nasobenie");
            System.out.println("4 - Delenie");
            volba = Integer.parseInt(sc.nextLine());
            System.out.print("Zadaj prve cislo: ");
            cisloA = Integer.parseInt(sc.nextLine());
            System.out.print("Zadaj druhe cislo: ");
            cisloB = Integer.parseInt(sc.nextLine());
            if(volba == 1) {
               System.out.println("Vysledok scitania je: " + kalkulacka.scitanie(cisloA, cisloB));
            }
            else if(volba == 2)
                System.out.println("Vysledok odcitania je: " + kalkulacka.odcitane(cisloA, cisloB));
            else if(volba == 3)
                System.out.println("Vysledok nasobenia je: " + kalkulacka.nasobenie(cisloA, cisloB));
            else if(volba == 4)
                System.out.println("Vysledok delenia je: " + kalkulacka.delenie(cisloA, cisloB));
            else
                System.out.println("Neplatna volba!");                                  
            System.out.print("Chces pokracovat[ano]/[nie]: ");
            pokracovat = sc.nextLine();
        }
        
        System.out.println("Dakujeme za pouzitie kalkulacky");
    }
    
}

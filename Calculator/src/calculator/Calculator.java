/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.util.Scanner;

/**
 *
 * @author Luxy
 */
public class Calculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "Windows-1250");
        Kalkulacka kalkulacka = new Kalkulacka();
        
        System.out.println("Zadaj 1. číslo:");
        kalkulacka.cisloX = Float.parseFloat(sc.nextLine());
        System.out.println("Zadaj 2. číslo:");
        kalkulacka.cisloY = Float.parseFloat(sc.nextLine());
        
        System.out.println("Súčet: " + kalkulacka.scitanie());
        System.out.println("Rozdiel: " + kalkulacka.odcitanie());
        System.out.println("Súčin: " + kalkulacka.nasobenie());
        System.out.println("Podiel: " + kalkulacka.delenie());
    }
    
}

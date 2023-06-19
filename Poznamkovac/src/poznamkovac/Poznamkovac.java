/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poznamkovac;

import java.util.Scanner;

/**
 *
 * @author Luxy
 */
public class Poznamkovac {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "Windows-1250");
        Diar diar = new Diar();
        String volba = "";
        // hlavny cyklus
        while (!volba.equals("4")) {
            diar.vypisUvodnuObrazovku();
            System.out.println();
            System.out.println("Vyberte si akciu");
            System.out.println("1 - pridat zaznam");
            System.out.println("2 - Vyhladat zaznamy");
            System.out.println("3 - Vymazat zaznam");
            System.out.println("4 - Koniec");
            volba = sc.nextLine();
            System.out.println();
            //reakcia na volbu
            switch (volba) {
                case "1":
                    diar.pridajZaznam();
                    break;
                case "2":
                    diar.vyhladajZaznamy();
                    break;
                case "3":
                    diar.vymazZaznamy();
                    break;
                case "4":
                    System.out.println("Lubovolnou klavesou ukoncite program...");
                    break;
                default:
                    System.out.println("Neplatna volba, stlacte lubovolnu klavesu a opakujte volbu");
                    break;
            }
        }
    }
    
}

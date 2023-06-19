/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package losovaniex;

import java.util.Scanner;
/**
 *
 * @author Luxy
 */
public class LosovanieX {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "Windows-1250");
        Losovac losovac = new Losovac();
        System.out.println("Vítajte v programe losovanie");
        String volba = "0";
        
        while (!(volba.equals("3"))) {
            System.out.println("1 - Losovať ďalšie číslo");
            System.out.println("2 - Vypísať čísla");
            System.out.println("3 - Koniec");
            volba = sc.nextLine();
            System.out.println();
            
            switch (volba) {
                case "1":
                    System.out.printf("Padlo číslo: %s\n", losovac.losuj());
                    break;
                case "2":
                    System.out.printf("Padli čísla: %s\n", losovac.vypis());
                    break;
                case "3":
                    System.out.println("Ďakujeme za použitie programe");
                    break;
                default:
                    System.out.println("Neplatná voľba, zadajte prosím znovu");
                    break;
            }
        }
        
        
    }
    
}

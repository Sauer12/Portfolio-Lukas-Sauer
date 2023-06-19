/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automobily;

/**
 *
 * @author Luxy
 */
public class Automobily {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Autobazar autobazar = new Autobazar("Luxove autá", "Pekinská 1", 5000000);
        autobazar.odkupAutomobil("123ABC", "Škoda 120", 10000);
        autobazar.odkupAutomobil("Škoda Fabia", "456DEF", 100000);
        autobazar.odkupAutomobil("789GHI", "Ferrari FF", 3000000);
        autobazar.odkupAutomobil("534NGS", "Tatra811", 50000, 20);
        autobazar.odkupAutomobil("489GSR", "Renault Midliner", 100000, 30);
        
        System.out.println("V bazare je " + autobazar.pocetAutomobilov() + " automobilov");
        System.out.println("Na pokladni je " + autobazar.getPeniaze() + " Kč");
        System.out.println("Celková cena automobilov je " + autobazar.cenaAutomobilov() + " Kč");
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strom;

/**
 *
 * @author Luxy
 */
public class Strom {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Trojuholnik trojuholnik = new Trojuholnik("Zelená", 25, 15, 15);
        Obdlznik obdlznik = new Obdlznik("Hnedá", 3, 26);
        System.out.print("Obsah stromu: ");
        System.out.println(trojuholnik.obsah() * 4 + obdlznik.obsah() + " cm^2");
    }
    
}

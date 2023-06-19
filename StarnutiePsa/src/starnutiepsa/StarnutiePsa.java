/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starnutiepsa;

/**
 *
 * @author Luxy
 */
public class StarnutiePsa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pes dunco = new Pes("Dunčo", 1);
        System.out.println(dunco);
        Osoba karol = new Osoba("Karol", dunco);
        Osoba anna = new Osoba("Anna", dunco);
        karol.pes.zostarni(1);
        anna.pes.zostarni(1);
        System.out.println(dunco);
        
    }
    
}

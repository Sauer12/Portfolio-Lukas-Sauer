/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tahovyboj;

/**
 *
 * @author Luxy
 */
public class TahovyBoj {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Vytvorenie
        Kocka kocka = new Kocka(10); 
        Bojovnik b1 = new Bojovnik("Zalgoren", 100, 20, 10, kocka);
        Bojovnik b2 = new Mag("Gandalf", 60, 15, 12, kocka, 30, 45);
        Arena arena = new Arena(b1, b2, kocka);
        
        arena.zapas();
      
    }
    
}

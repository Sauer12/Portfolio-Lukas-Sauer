/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piesok;

/**
 *
 * @author Luxy
 */
public class Piesok {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NakladneAuto nakladneAuto = new NakladneAuto(3000);
        nakladneAuto.Naloz(10000);
        nakladneAuto.Naloz(500);
        nakladneAuto.Vyloz(300);
        nakladneAuto.Vyloz(1000);
        System.out.println("V nákladnom aute je naložených " + nakladneAuto.getNaklad() + " kg");
    }
    
}

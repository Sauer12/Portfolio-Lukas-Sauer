/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arkanoid;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luxy
 */
public class Arkanoid {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        Hra hra = new Hra(8, 5);
        hra.vytvorHernuPlochu();
        boolean koniec = false;
        
        while(!koniec) {       
            hra.vykresli();
            Thread.sleep(500);
            hra.pohyb();
        }
        System.out.println("Game Over");
    }
    
}

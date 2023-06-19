/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unava;

/**
 *
 * @author Luxy
 */
public class Unava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Clovek clovek = new Clovek("Karol Nový", 25);
        System.out.println(clovek);
        for(int i = 0; i < 3; i++) {
            if(i == 1)
                clovek.spi(1);
            clovek.bez(10);
        }
    }
    
}

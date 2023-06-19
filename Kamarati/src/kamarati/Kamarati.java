/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kamarati;

/**
 *
 * @author Luxy
 */
public class Kamarati {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Clovek karol = new Clovek("Karol Novák", 37);
        Clovek jozef = new Clovek("Jozef Nový", 27);
        karol.skamaradSa(jozef);
        jozef.skamaradSa(karol);
        System.out.println(karol);
        System.out.println(jozef);
    }
    
}

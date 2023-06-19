/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vtaci;

/**
 *
 * @author Luxy
 */
public class Vtaci {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Vtak vtak = new Vtak(100, 50);
        AngryVtak angryVtak = new AngryVtak(100, 50, 50);
        System.out.println(vtak);
        vtak.zjedz(20);
        System.out.println(vtak);
        System.out.println(angryVtak);
        angryVtak.provokuj(5);
        System.out.println(angryVtak);
        angryVtak.zjedz(100);
        angryVtak.provokuj(5);
        System.out.println(angryVtak);
        
        
    }
    
}

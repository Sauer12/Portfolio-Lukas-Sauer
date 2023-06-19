/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloobjectworld;

/**
 *
 * @author Luxy
 */
public class HelloObjectWorld {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Zdravic zdravic;
        zdravic = new Zdravic();
        zdravic.text = "Ahoj ";
        System.out.println(zdravic.pozdrav("Marek"));
        System.out.println(zdravic.pozdrav("Karol"));
        zdravic.text = ("Vitam ta ");
        System.out.println(zdravic.pozdrav("Richard"));
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circle;

import java.util.Scanner;
/**
 *
 * @author Luxy
 */
public class Circle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "Windows-1250");
        System.out.println("Write the radius of circle");
        Float radius = Float.parseFloat(sc.nextLine());
        Float pi = 3.1415F;
        Float circumference = 2 * pi * radius;
        Float volume = pi * radius * radius;
        System.out.println("Circumference of circle is: " + circumference + " cm");
        System.out.println("Volume of circle is: " + volume + " cm^2");
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quadraticequation;

import java.util.Scanner;
        
/**
 *
 * @author Luxy
 */
public class QuadraticEquation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "Windows-1250");
        
        System.out.println("Type a");
        double a = Double.parseDouble(sc.nextLine());
        System.out.println("Type b");
        double b = Double.parseDouble(sc.nextLine());
        System.out.println("Type c");
        double c = Double.parseDouble(sc.nextLine());
        
        double Diskriminant = b*b - 4 * a * c;
        double result = 0;
        double resultX = 0;
        
        
        if (Diskriminant < 0)
            System.out.println("The equation has no solution");
        else if (Diskriminant == 0){
            result = (-b + Math.sqrt(Diskriminant)) / (2*a);
            System.out.println("X1,2 : = " + result);
        }
        else{
            result = (-b + Math.sqrt(Diskriminant)) / (2*a);
            resultX = (-b - Math.sqrt(Diskriminant)) / (2*a);
            System.out.println("X1: = " + result);
            System.out.println("X2: = " + resultX);
        }
            
            
            
            
                
    }
    
}

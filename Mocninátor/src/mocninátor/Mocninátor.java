/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocninátor;

import java.util.Scanner;
/**
 *
 * @author Luxy
 */
public class Mocninátor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "Windows-1250");
        System.out.println("Mocninátor");
        System.out.println("==========");
        System.out.println("Enter the base of the square");
        int a = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the exponent");
        int n = Integer.parseInt(sc.nextLine());
        
        int result = a;
        for (int i=0; i < (n - 1); i++){
            result = result * a;
        }
        
        System.out.println("Result: " + result);
        System.out.println("Thank you for using our Mocninátor");
            
    }
    
}

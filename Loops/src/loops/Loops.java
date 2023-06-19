/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loops;

import java.util.Scanner;
/**
 *
 * @author Luxy
 */
public class Loops {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "Windows-1250");
        for (int i=0; i < 10; i++)
        {
            System.out.println("Knock");
        }
        System.out.println("Penny!");
        
        for (int i = 1; i <= 10; i++){
            for (int j = 1; j <= 10; j++)
                System.out.print((i * j) + " ");
            System.out.println();
        }
            
    }
    
}

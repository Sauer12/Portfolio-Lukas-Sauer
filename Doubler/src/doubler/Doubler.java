/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doubler;

import java.util.Scanner;
/**
 *
 * @author Luxy
 */
public class Doubler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "Windows-1250");
        System.out.println("Write the number to doubling");
        String s = sc.nextLine();
        int number = Integer.parseInt(s);
        number = number * 2;
        System.out.println(number);
        
        
    }
    
}

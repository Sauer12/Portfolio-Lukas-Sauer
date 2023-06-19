/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nameandproperty;

import java.util.Scanner;

public class NameAndProperty {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "Windows-1250");
        System.out.println("Hello, what is your name?");
        String name = sc.nextLine();
        System.out.println("And what property do you have?");
        String property = sc.nextLine();
        System.out.println(name + " is " + property);
    }
    
}

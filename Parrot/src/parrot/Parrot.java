/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parrot;

import java.util.Scanner;

/**
 *
 * @author Luxy
 */
public class Parrot {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "Windows-1250");
        System.out.println("Hello, I am virtual parrot Lora, I like to repeat ");
        System.out.println("Write something: ");
        String input;
        input = sc.nextLine();
        String output;
        output = input + ", " + input + "!";
        System.out.println(output);
    }
    
}

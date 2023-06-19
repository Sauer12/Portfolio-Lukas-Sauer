/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lengthofstrings;

import java.util.Scanner;
/**
 *
 * @author Luxy
 */
public class LengthOfStrings {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "Windows-1250");
        System.out.println("Write first word: ");
        String first = sc.nextLine().trim();
        System.out.println("Write second word: ");
        String second = sc.nextLine().trim();
        int firstlength = first.length();
        int secondlength = second.length();
        int length = firstlength - secondlength;
        System.out.println("The words differ by " + length + " characters");               
    }
    
}

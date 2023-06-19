/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itnetworkstring;

import java.util.Scanner;
/**
 *
 * @author Luxy
 */
public class ItnetworkString {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "Windows-1250");
        System.out.println("Write some string:");
        String s = sc.nextLine().trim().toLowerCase();
        System.out.println(s.contains("itnetwork"));
    }
    
}

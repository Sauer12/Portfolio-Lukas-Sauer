/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fishes;

import java.util.Scanner;
/**
 *
 * @author Luxy
 */
public class Fishes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in, "Windows-1250");
        System.out.println("How many fishes do you want?");
        int fishes = Integer.parseInt(sc.nextLine());
        for (int i=0; i < fishes; i++){
            System.out.println("<° )))-<");
        }
    }
    
}

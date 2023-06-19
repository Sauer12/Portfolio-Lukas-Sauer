/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slova;

import java.util.Scanner;

/**
 *
 * @author Luxy
 */
public class Slova {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "Windows-1250");
        SlovaList slova = new SlovaList();
        boolean koniec = false;
        
        while(!koniec) {
            System.out.print("Zadaj slovo: ");
            String s = sc.nextLine().toLowerCase();
            if(s.equals("koniec"))
                koniec = true;
            else
                slova.pridajSlovo(s);
        }
        slova.vypisSlova();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fields;

import java.util.Scanner;
import java.util.Arrays;
/**
 *
 * @author Luxy
 */
public class Fields {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "Windows-1250");
        int[] field = new int[10];
        
        for (int i = 0; i < 10; i++){
            field[i] = i + 1;
        }
        
        /*for (int i = 0; i < field.length; i++){
            System.out.print(field[i] + " ");
        }*/
        
        for (int i : field){
            System.out.print(i + " ");
        }
        
        String[] simpsons = {"Homer", "Marge", "Bart", "Lisa", "Maggie"};
        for (String s : simpsons){
            System.out.print(s + " ");
        }
        
        System.out.println("Zadaj simpsna: ");
        String simpson = sc.nextLine();
        
        Arrays.sort(simpsons);
        int pozicia = Arrays.binarySearch(simpsons, simpson);
        if (pozicia >= 0)
            System.out.println("Jo, to je Simpson!");
        else
            System.out.println("To nie je Simpson!");
            
    }
    
}

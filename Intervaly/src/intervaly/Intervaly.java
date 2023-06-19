/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intervaly;

import java.util.Scanner;
/**
 *
 * @author Luxy
 */
public class Intervaly {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in,"Windows-1250");
        System.out.println("Zadaj ľavú medzu 1. intervalu");
        int xx = Integer.parseInt(sc.nextLine());
        System.out.println("Zadaj pravú medzu 1. intervalu");
        int xy = Integer.parseInt(sc.nextLine());
        System.out.println("Zadaj ľavú medzu 2. intervalu");
        int yy = Integer.parseInt(sc.nextLine());
        System.out.println("Zadaj pravú medzu 2. intervalu");
        int yx = Integer.parseInt(sc.nextLine());
        
        for (int i = xx; i <= xy; i++){
            for (int j = yy; j <= yx; j++){
                if(((i + j) <= xy) || ((i + j) <= yx))
                System.out.print("[" + i + ";" + j + "]");
            }
            System.out.println();
        }
    }
    
}

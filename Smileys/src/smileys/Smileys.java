/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smileys;

import java.util.Scanner;
/**
 *
 * @author Luxy
 */
public class Smileys {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "Windows-1250");
        
        String smiley = sc.nextLine();
        smiley = smiley.replace("-","");
        
        switch(smiley){
            case ":)":
                System.out.println("Your smiley is happy");
            break;      
            case ":(":
                System.out.println("Your smiley is sad");
            break;
            case ":*":
                System.out.println("Your smiley is in love");
            break;
            case ":P":
                System.out.println("Your smiley is with tongue out");
            break;
            default:
                System.out.println("Your smiley is unknow");                   
        }
    }
    
}

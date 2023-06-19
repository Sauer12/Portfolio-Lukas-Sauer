/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package namevalidator;

import java.util.Scanner;
/**
 *
 * @author Luxy
 */
public class NameValidator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "Windows-1250");
        System.out.println("Enter your nickname:");
        String nickname = sc.nextLine();
        if(nickname.length() < 3 || nickname.length() > 10)
        {
           System.out.println("Your nickname is very short or long");
        }
        else
            System.out.println("Your nickname is normal");
        
    }
    
}

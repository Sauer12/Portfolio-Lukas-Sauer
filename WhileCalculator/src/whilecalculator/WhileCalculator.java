/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whilecalculator;

import java.util.Scanner;
/**
 *
 * @author Luxy
 */
public class WhileCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "Windows-1250");
        
        System.out.println("Welcome in the calculator");
        String continuee = "yes";
        while (continuee.equals("yes"))
        {
            System.out.println("Enter the first number");
            float a = Float.parseFloat(sc.nextLine());
            System.out.println("Enter the second number");
            float b = Float.parseFloat(sc.nextLine());
            System.out.println("Choose operation:");
            System.out.println("1 - addition");
            System.out.println("2 - subtraction");
            System.out.println("3 - multiplication");
            System.out.println("4 - division");
            int choose = Integer.parseInt(sc.nextLine());
            float result = 0;
            switch(choose){
                case 1:
                    result = a + b;
                break;
                case 2:
                    result = a - b;
                break;
                case 3:
                    result = a * b;
                break;
                case 4:
                    result = a / b;
                break;             
            }
            if ((choose > 0) && (choose < 5))
                System.out.println("Result: " + result);
            else
                System.out.println("Invalid choose");
            System.out.println("Do you want to continue? [yes / no]");
            continuee = sc.nextLine();
        }
        System.out.println("Thank you for using our calculator");
    }
    
}

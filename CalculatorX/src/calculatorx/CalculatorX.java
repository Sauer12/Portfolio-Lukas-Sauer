/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorx;

import java.util.Scanner;
/**
 *
 * @author Luxy
 */
public class CalculatorX {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "Windows-1250");
        System.out.println("Welcome in the calculator");
        System.out.println("Write the first number:");
        float a = Float.parseFloat(sc.nextLine());
        System.out.println("Write the second number:");
        float b = Float.parseFloat(sc.nextLine());
        System.out.println("Choose operation:");
        System.out.println("1 - addition");
        System.out.println("2 - subtraction");
        System.out.println("3 - multiplication");
        System.out.println("4 - division");
        int choose = Integer.parseInt(sc.nextLine());
        float result = 0;
        switch (choose){
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
        if ((choose > 0) && (choose < 5 ))
        {
            System.out.println("Result: " + result);
        }
        else
        {
            System.out.println("Invalid selection");
        }
        System.out.println();
        System.out.println("Thank you for using our calculator");
    }
    
}

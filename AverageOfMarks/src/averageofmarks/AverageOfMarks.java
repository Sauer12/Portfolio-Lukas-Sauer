/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package averageofmarks;

import java.util.Scanner;
import java.util.Arrays;
/**
 *
 * @author Luxy
 */
public class AverageOfMarks {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "Windows-1250");
        
        System.out.println("Hello,I'll calculate the average of your marks, how many marks do you have?");
        int count = Integer.parseInt(sc.nextLine());
        int[] numbers = new int[count];
        for (int i = 0; i < count; i++){
            System.out.printf("Enter the %d. number: ", i + 1);
            numbers[i] = Integer.parseInt(sc.nextLine());
        }
        
        int sum = 0;
        for (int i: numbers) {
            sum += i;
        }
        float average = sum / (float)numbers.length;
        
        System.out.printf("Average of yours marks is: %f", average);

    }
    
}

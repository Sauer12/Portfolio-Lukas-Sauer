package sk.lukas.syntax;

import java.util.*;
import 	java.util.Random;
import java.util.Arrays;

public class Main {

	
	public static void main(String[] args) {
		
		Random random = new Random();
		
		int[][] array = new int[4][6];
		array[0] = new int[random.nextInt(11) + 1];
		array[2] = new int[random.nextInt(11) + 1];
		array[3] = new int[random.nextInt(11) + 1];
		
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				array[i][j] = random.nextInt(21);
			}
		}
		
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
		
		int[]array2 = {1,5,10,2,6,8};
		int sucet = 0;
		int sucin = 1;
		
		for(int i = 0; i < array2.length; i++) {
			sucet += array2[i];
			sucin *= array2[i];
		}
		
		System.out.println(sucet);
		System.out.println(sucin);		
		
		sucin = 1;
		sucet = 0;
		
		int[][] array3 = {{5, 10, 5}, {10,15,6}, {8,3,1}};
		
		for(int i = 0; i < array3.length; i++) {
			for(int j =0; j < array3[i].length; j++) {
				sucet += array3[i][j];
				sucin *= array3[i][j];
			}
		}
		
		System.out.println(sucet);
		System.out.println(sucin);
		
		System.out.println("Dvojrozmerne pole, sucet 0-tych, 1-ntych.. n-tych prvkov:");
		sucet = 0;
		
		int[][] array4 = {{10, 2, 5}, {5, 3,8,9}, {8, 2, 2, 5}};
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < array4.length; j++) {
				if(i < array4[j].length)
					sucet += array4[j][i];
				}
				System.out.println(sucet);
				sucet = 0;
		}
		
		System.out.println(upperCase("ahoj"));
		System.out.println(upperCase("idk"));
		
		
		System.out.println(porovnanieStringov("Karol", "Marek"));
		System.out.println(porovnanieStringov("Ahoj", "Ahoj"));
		
		dayOfWeek(DaysOfWeek.MONDAY);
		dayOfWeek(DaysOfWeek.SATURDAY);
		
		System.out.println(Strany.NORTH.shortName);
		System.out.println(Strany.SEVER.shortName);
			
	}
	
	
	
	static void dayOfWeek(DaysOfWeek day) {
		switch(day) {
			case MONDAY:
			case TUESDAY:
			case WEDNESDAY:
			case THURSDAY:
			case FRIDAY:
				System.out.println("Its a week");
				break;
			case SATURDAY:
			case SUNDAY:
				System.out.println("Its a weekend");
				break;
		}
			
	}
	
	static String upperCase(String text) {
		return text.toUpperCase();
	}
	
	static boolean porovnanieStringov(String text1, String text2) {
		if(text1.equals(text2))
			return true;
		else
			return false;
	}
	
	
	static void dayOfWeek(String day) {
		switch(day) {
			case "monday":
				System.out.println("Je pondelok");
				break;
			case "tuesday":
				System.out.println("Je utorok");
				break;
			case "wednesday":
				System.out.println("Je streda");
				break;
			case "thursday":
				System.out.println("Je stvrtok");
				break;
			case "friday":
				System.out.println("Je piatok");
				break;
			case "saturday":
			case "sunday":
				System.out.println("Je vikend");
				break;
			default:
				System.out.println("Zadal si neplatny den");
		}
	}
	
	
}



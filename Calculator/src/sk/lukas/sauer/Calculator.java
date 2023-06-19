package sk.lukas.sauer;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String pokracovat = "ano";
		System.out.println("Ahoj, vitaj v kalkulacke!\nTato aplikacia funguje tak, ze zadas prve cislo, druhe cislo a vyberes operaciu.\nMozes zacat :-)");
		while(pokracovat.equals("ano")) {
			
			System.out.print("Zadaj prve cislo: ");
			int cislo1 = sc.nextInt();
			sc.nextLine();
			System.out.print("Zadaj druhe cislo: ");
			int cislo2 = sc.nextInt();
			sc.nextLine();	
			
			System.out.print("\nVyber operaciu:\n1-scitanie\n2-odcitanie\n3-nasobenie\n4-delenie\nTvoja volba (1-4): ");
			int operacia = sc.nextInt();
			sc.nextLine();
			
			switch(operacia) {
				case 1: 
					Operacie.scitaj(cislo1, cislo2);
					break;
				case 2:
					Operacie.odcitaj(cislo1, cislo2);
					break;
				case 3:
					Operacie.vynasob(cislo1, cislo2);
					break;
				case 4:
					Operacie.vydel(cislo1, cislo2);
					break;
				default:
					System.out.println("Neplatna operacia!");
			}
			
			System.out.print("Chces pokracovat? [ano/nie]: ");
			pokracovat = sc.nextLine().toLowerCase(); 
		}		
		sc.close();
		System.out.println("Ukoncil si program!");
	}
}

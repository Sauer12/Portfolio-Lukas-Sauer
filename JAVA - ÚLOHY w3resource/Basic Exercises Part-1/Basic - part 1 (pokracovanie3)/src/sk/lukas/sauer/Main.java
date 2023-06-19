package sk.lukas.sauer;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int[] pole = new int[] {20, 15, 20, 5, 10, 15, 20};
		int[] pole2 = new int[] {25, 5, 10, 5, 5, 3, 2};
		
//		1.
//		merajCasBehuProgramu(100);   
//		2.
//		parneNeparnePrvky(new int[]{ 10, 2, 5, 3, 11, 23 });
//		3.
//		System.out.println(desatDvadsat(pole));
//		4. 
//		pole = preusporiadajPoleNeparneParne(pole);
//		for(int i : pole) {
//			System.out.print(i + " ");
//		}
//		5.
//		vytvorPoleNaplnPole(20);
//		6. 
//		System.out.println(desatDvadsatVPoli(pole));
//		7.
//		System.out.println(rovnakeCisla(pole));
//		8.
//		System.out.println(trikratDvadsat(pole));
//		9.
//		spocitajPrvkyPoli(pole, pole2);
//		10.
		rozdielPrvkovVPoliach(pole, pole2);
		
	}
	
//	1. Program, ktory ziska hodnotu toho ako dlho trva vykonanie nejakeho kodu
	public static void merajCasBehuProgramu(int pocet) {
		long startTime = System.nanoTime();
		
		System.out.println("Pocet: " + pocet);
		for(int i = 0; i < pocet; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		long konecnyCas = System.nanoTime() - startTime;
		
		System.out.println("Cas v nanosekundach: " + konecnyCas);
	}

//	2. Spocita pocet parnych a neparnych prvkov v poli
	public static void parneNeparnePrvky(int[] pole) {
		int pocetParnych = 0;
		int pocetNeparnych = 0;
		
		for(int i : pole) {
			if(i % 2 == 0) {
				pocetParnych++;
			}
			else {
				pocetNeparnych++;
			}
		}
		
		System.out.println("Pocet parnych: " + pocetParnych);
		System.out.println("Pocet neparnych: " + pocetNeparnych);
	}
	
//	3. 10 vedla 10 alebo 20 vedla 20 v poli, ale nie oboje zaroven
	public static boolean desatDvadsat(int[] pole) {
		boolean obsahujePrvky = false;
		boolean desat = false;
		boolean dvadsat = false;
		
		for(int i = 0; i < pole.length; i++) {
			if(pole[i] == 10) {
				if((i + 1) < pole.length) {
					if(pole[i+1] == 10) {
						obsahujePrvky = true;
						desat = true;
					}
				}
				if((i - 1) >= 0) {
					if(pole[i-1] == 10) {
						obsahujePrvky = true;
						desat = true;
					}
				}
			}
			if(pole[i] == 20) {
				if((i + 1) < pole.length) {
					if(pole[i+1] == 20) {
						obsahujePrvky = true;
						dvadsat = true;
					}
				}
				if((i - 1) >= 0) {
					if(pole[i-1] == 20) {
						obsahujePrvky = true;
						dvadsat = true;
					}
				}
			}			
		}
		
		if(desat && dvadsat) {
			obsahujePrvky = false;
		}
		
		return obsahujePrvky;
	}

//	4. Zobere pole a preusporiada ho tak, ze vsetky neparne cisla budu pred parnymi cislami 
	public static int[] preusporiadajPoleNeparneParne(int[] pole) {
		int index = 0;
		int[] resultArray = new int[pole.length];
		Arrays.sort(pole);
		
		
		for(int i = 0; i < pole.length; i++) {
			if(pole[i] % 2 != 0) {
				resultArray[index] = pole[i];
				index++;
			}
		}
		
		for(int i = 0; i < pole.length; i++) {
			if(pole[i] % 2 == 0) {
				resultArray[index] = pole[i];
				index++;
			}
		}	
		
		return resultArray;
	}

//  5. Vytvori pole vo velkosti N a bude obsahovat prvky od 1 po n
	public static void vytvorPoleNaplnPole(int velkost) {
		String[] pole = new String[velkost];
		
		for(int i = 0; i < velkost; i++) {
			pole[i] = Integer.toString(i + 1);
		}
		
		for(String s : pole) {
			System.out.println(s);
		}		
	}	

//	6. Zisti ci sa v poli nachadza 10 spolu s 20 ktora je neskor v poli
	public static boolean desatDvadsatVPoli(int[] pole) {
		boolean desat = false;
		
		for(int i = 0; i < pole.length; i++) {
			if(pole[i] == 10) {
				desat = true;
			}
			if(desat) {
				if(pole[i] == 20) {
					return true;
				}
			}
		}
		
		return false;
	}

//	7. Zisti ci sa v poli nachadzaju vedla seba dve rovnake cisla alebo ci existuju dve rovnake cisla oddelene jednym prvkom
	public static boolean rovnakeCisla(int[] pole) {		
		for(int i = 0; i < pole.length; i++) {
			if(i + 1 < pole.length) {
				if(pole[i] == pole[i + 1]) {
					return true;
				}
				else if(i + 2 < pole.length) {
					if(pole[i] == pole[i + 2]) {
						return true;
					}
				}
			}
		}
		
		return false;
	}

//  8. Zisti ci sa hodnota 20 nachadza v poli trikrat, ale jednotlive 20ky sa nenachadzaju vedla seba
	public static boolean trikratDvadsat(int[] pole) {
		int pocet = 0;
		int dvadsat = 0;
		
		for(int i = 0; i < pole.length; i++) {			
			if(((i - 1) >= 0) && ((i + 1) < pole.length)) {
				if(pole[i] == 20) {
					if((pole[i - 1] != 20) && (pole[i + 1] != 20)) {
						pocet++;
					}
				}
			}
			else if(i == 0) {
				if(pole[i] == 20 && pole[i + 1] != 20) {
					pocet++;
				}
			}
			else if(i < pole.length) {
				if(pole[i] == 20 && pole[i - 1] != 20) {
					pocet++;
				}
			}
			
			if(pole[i] == 20) {
				dvadsat++;
			}
		}
		
		if(pocet == 3 && dvadsat == 3) {
			return true;
		}
		
		return false;
	}

//	9. Spocita dva prvky dvoch rozdielnych poli na rovnakych indexoch s rovnakou velkostou
	public static void spocitajPrvkyPoli(int[] pole1, int[] pole2) {
		if(pole1.length == pole2.length) {
			for(int i : pole1) {
				System.out.print(i + " ");
			}
			System.out.println();
			for(int i : pole2) {
				System.out.print(i + " ");
			}
			System.out.println();
			for(int i = 0; i < pole1.length; i++) {
				int sum = pole1[i] + pole2[i];
				System.out.print(sum + " ");
			}
		}
		else {
			System.out.println("Polia nemaju rovnaku dlzku!");
		}			
	}

//	10. pocitanie prvkov v poliach s rovnakou dlzkou a vypisanie absolutnej hodnoty medzi prvkami s rovnakym indexom
	public static void rozdielPrvkovVPoliach(int[] pole1, int[] pole2) {
		if(pole1.length == pole2.length) {
			for(int i : pole1) {
				System.out.print(i + " ");
			}
			System.out.println();
			for(int i : pole2) {
				System.out.print(i + " ");
			}
			System.out.println();
			
			for(int i = 0; i < pole1.length; i++) {
				int rozdiel = pole1[i] - pole2[i];
				rozdiel = Math.abs(rozdiel);
				System.out.print(rozdiel + " ");
			}
			
		}
	}
}

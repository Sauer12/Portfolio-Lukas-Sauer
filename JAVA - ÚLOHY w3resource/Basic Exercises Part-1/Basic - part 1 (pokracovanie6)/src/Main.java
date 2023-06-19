import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int[] array = new int[] {10, 3, 2, 9, 12, 3, 3, 5};
		int[][] matrix = new int[][] { {3, 2, 3, 4}, {10, 5, 20, 2}, {5, 3, 2} };
		int[] pole = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		float[] pole2 = new float[] {10, 2, 38, 22, 38, 23};
		int[] pole3 = new int[] {10, 20, 10, 20, 35, 30, 40, 666, 40, 30, 50, 35, 50};
		
//		1.
//		System.out.println(najdiElement(5, array));
//		2.
//		najdiElementVMatrixe(5, matrix);
//		3.
//		obratPole(array);
//		4.
//		najdiNajvacsieSubarray(pole);
//		5.
//		najdiNajmensieSubarray(new int[] {-2, 1, -3, 4});
//		6.
//		System.out.println(najdiIndexPrvku(array, 11));
//		7.
//		System.out.println(najdiMedianVPoli(pole2));
//		8. 
		System.out.println(vyskytJedenKratVPoli(pole3));
	}
	
//	1. Najde prvy vyskyt elementu v poli a vrati jeho index, ak ho nenajde, vrati -1
	public static int najdiElement(int hladanyElement, int[] array) {
		
		for(int i = 0; i < array.length; i++) {
			if(array[i] == hladanyElement) {
				return i;
			}
		}
		
		return -1;
	}

//	2. Najde prvy vyskyt elementu v dvojrozmernom poli a vrati jeho index, ak ho nenajde, vrati -1
	public static void najdiElementVMatrixe(int hladanyElement, int[][] matrix) {
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				if(matrix[i][j] == hladanyElement) {
					System.out.println("Prvy vyskyt elementu " + hladanyElement + " sa nachadza na [" + i + "][" + j + "]");
					return;
				}
			}
		}
		
	}

//	3. Obrati pole
	public static void obratPole(int[] pole) {
		int[] pomocnePole = new int[pole.length];
		
		for(int i = pole.length - 1, j = 0; i >= 0; i--, j++) {
			pomocnePole[j] = pole[i];
		}
		
		for(int i = 0; i < pole.length; i++) {
			pole[i] = pomocnePole[i];
		}
		
		for(int i : pole) {
			System.out.print(i + " ");
		}
	}
	
//	4. Najde v poli podpole s najvacsim suctom
	public static void najdiNajvacsieSubarray(int[] pole) {
		int max = 0;
		
		for(int i = 0; i < pole.length; i++) {
			int sucet = pole[i];
			if(sucet > max) {
				max = sucet;
			}
			for(int j = i + 1; j < pole.length; j++) {
				sucet += pole[j];
				if(sucet > max) {
					max = sucet;
				}
			}
		}
		
		System.out.println(max);
	}

//	5. Najde v poli podpole s najmensim suctom
	public static void najdiNajmensieSubarray(int[] pole) {
		int min = 0;
		
		for(int i = 0; i < pole.length; i++) {
			int sucet = pole[i];
			if(pole[i] < min) {
				min = pole[i];
			}
			for(int j = i + 1; j < pole.length; j++) {
				sucet += pole[j];
				if(sucet < min) {
					min = sucet;
				}
			}
		}
		
		System.out.println(min);		
	}

//  6. Najde index daneho prvku v zotriedenom poli, ak sa prvok nenachadza v poli, vrati index, kde by sa nachadzal
	public static int najdiIndexPrvku(int[] pole, int hladanyPrvok) {
		Arrays.sort(pole);
		
		for(int i : pole) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		
		for(int i = 0; i < pole.length; i++) {
			if(pole[i] == hladanyPrvok)
				return i;			
		}
		
		if(pole[0] > hladanyPrvok)
			return 0;			
		else if(hladanyPrvok > pole[0] && hladanyPrvok < pole[pole.length - 1]) {
			for(int i = 0; i < pole.length; i++) {
				if(pole[i] < hladanyPrvok && pole[i + 1] > hladanyPrvok) {
					return i+1;
				}
			}
		}			
		
		return pole.length;		
	}

//  7. Zobere pole a najde median
	public static double najdiMedianVPoli(float[] pole) {
		Arrays.sort(pole);
		
		if(pole.length % 2 == 1)
			return pole[(pole.length - 1) / 2];
		else 
			return (pole[pole.length / 2] + pole[pole.length / 2 - 1]) / 2;  
	}

//	8. Najde cislo v poli, ktore sa vyskytuje iba raz zatialco ostatne cisla sa vyskytuju dvakrat
	public static int vyskytJedenKratVPoli(int[] pole) {
		boolean cislo = false;
		
		for(int i = 0; i < pole.length; i++) {
			for(int j = 0; j < pole.length; j++) {
				if(j == pole.length - 1) {
					cislo = true;
				}
				if(i == j) {
					continue;
				}				
				if(pole[i] == pole[j]) {
					cislo = false;
					break;
				}				
			}
			if(cislo)
				return pole[i];
		}
		
		return -1;
	}

//	9. Vymaze duplikaty v poli a vypise dlzku upraveneho pola
	public static int vymazDuplikatyVPoli(int[] pole) {
		
	}
	
	
}

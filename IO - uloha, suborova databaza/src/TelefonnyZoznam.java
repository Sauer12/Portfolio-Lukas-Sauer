//import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.reflect.Array;
import java.util.Scanner;

public class TelefonnyZoznam {
	
	private String cesta;
	private String nazovSuboru;
	private int pocetZoznamov;
	
	public TelefonnyZoznam(String cesta, String nazovSuboru) {
		this.cesta = cesta;
		this.nazovSuboru = nazovSuboru;
		pocetZoznamov = 0;
	}
	
	public void vytvorSubor() {
		try {
			File novySubor = new File(cesta + "\\" + nazovSuboru);
			if(novySubor.createNewFile()) {
				System.out.println("Subor: " + novySubor.getName() + " bol vytvoreny.");
				System.out.println("Cesta k suboru: " + cesta);
				pridajRiadok("Zoznam kontaktov");
				pridajRiadok(pocetZoznamov);
				pridajRiadok("Meno;Telefón;Mobil;Email");
			} else {
				System.out.println("Subor uz existuje.");
			}
		} catch (IOException e) {
			System.out.println("Nastala chyba!");
			e.printStackTrace();
		}
	}
	
	public void pridajKontakt(Kontakt kontakt) {
		pocetZoznamov++;
		FileWriter fw;
		
		try {
			fw = new FileWriter(cesta + "\\" + nazovSuboru, true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write(kontakt.getMeno() + ";");
			
			if(kontakt.getTelefon() == "") {
				bw.write("" + ";");
			} else {
				bw.write(kontakt.getTelefon() + ";");
			}
			
			if(kontakt.getMobil() == "") {
				bw.write("" + ";");
			} else {
				bw.write(kontakt.getMobil() + ";");
			}
			
			if(kontakt.getEmail() == "") {
				bw.write("");
			} else {
				bw.write(kontakt.getEmail());
			}
			
			bw.newLine();
			bw.close();	
			System.out.println("Kontakt " + kontakt.getMeno() + " si úspešne pridal do zoznamu.");			
		} catch (IOException e){
			System.out.println("Nastala chyba pri pridavani novych udajov do suboru.");
			e.printStackTrace();
		}
	}
	
	private void pridajRiadok(String text) throws IOException {
		FileWriter fw = new FileWriter(cesta + "\\" + nazovSuboru, true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(text);
		bw.newLine();
		bw.close();		
	}
	
	private void pridajRiadok(int text) throws IOException {
		FileWriter fw = new FileWriter(cesta + "\\" + nazovSuboru, true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(Integer.toString(text));
		bw.newLine();
		bw.close();		
	}

	public void editujCisloPoctuZoznamov() throws IOException {	
		Scanner sc = new Scanner(new FileInputStream(cesta + "\\" + nazovSuboru));
		sc.useDelimiter("\n");
		int riadok = 0;
		String pomocna = "";
		
		while(sc.hasNext()) {	
			sc.next();
			riadok++;
			if(riadok == 1) {
				pomocna = sc.next();
			}
		}
		pomocna = pomocna.replaceAll("\\s", "");
		pocetZoznamov += Integer.parseInt(pomocna);
		System.out.println("Pocet riadkov: " + (riadok + 1));
		sc.close();
		
		sc = new Scanner(new FileInputStream(cesta + "\\" + nazovSuboru));
		sc.useDelimiter("\n");		
		String[] zoznamy = new String[riadok + 1];
		int i = 0;		
		
		while(sc.hasNext()) {
			if(i == 1) {
				zoznamy[i] = String.valueOf(pocetZoznamov) + "\n";
				sc.next();
			}
			else {
				zoznamy[i] = sc.next();				
			}
			i++;
		}
		
		for(String s : zoznamy) {
			System.out.print(s);
		}
		
		sc.close();		
//		prepisSubor(zoznamy);	
		
	}
	
	private void prepisSubor(String[] data) {
		try {
			File file = new File (cesta + "\\" + nazovSuboru);
			if(file.delete()) {
				System.out.println("Vymazal si subor");
			}
			else
				System.out.println("Subor sa nevymazal..");
		} catch(Exception e) {
			e.printStackTrace();
		}			
		
		try {
			File novySubor = new File(cesta + "\\" + nazovSuboru);
			if(novySubor.createNewFile()) {
				for(String s : data) {
					
				}
			}
		} catch (IOException e) {
			System.out.println("Nastala chyba!");
			e.printStackTrace();
		}		
	
	}	
}

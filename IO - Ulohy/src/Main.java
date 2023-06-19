import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Main {

	public static void main(String[] args) throws IOException {
		String cesta = "C:\\Users\\lsaue\\Dropbox\\Programovanie\\Java - 2022\\IO - Ulohy\\src";
		String priecinok = "C:\\Users\\lsaue\\Dropbox\\Programovanie\\Java - 2022\\IO - Ulohy\\subor.txt";
// 1.
//		inputStream(cesta);
//		fileInputStream(cesta);
//		bufferReader(cesta);
// 2. 
//		pridajRiadok(cesta, "\ntoto je novy text.");
// 3. 
//		najdiNajdlhsieSlovoVSubore(cesta);
// 4.
//		vypisVelkostSuboru(cesta);
// 5.
//		vypisSuborPriecinok(cesta);
// 6.
//		vypisSuboryVPriecinku(priecinok);
// 7.
//		 vymazSubor(priecinok);
// 8. 
//		skopirujSubor(priecinok, cesta);
// 9.
		vytvorSubor("test.txt");
// 10.
		vytvorSubor("data.txt", cesta);
	}
	
// 1. Metoda precita textovy subor a vypise jeho text na konzolu (FileInputStream) - necita slovenske znaky, cita po bitoch
	public static void inputStream(String cesta) throws IOException {
//		FileOutputStream out = null;
		FileInputStream in = null;
		
		try {
//			out = new FileOutputStream(cesta);
			in = new FileInputStream(cesta);
			
			int c;
			
			while((c = in.read()) != -1) {
				System.out.print((char)c);
			}			
		} finally {
			if (in != null) {
				in.close();
			}
		}		
	}
// 1. Metoda precite textovy subor a vypise jeho text na konzolu (FileReader) - cita aj slovenske znaky, cito po znakoch
	public static void fileInputStream(String cesta) throws IOException {
		FileReader inputStream = null;
		
		try {
			inputStream = new FileReader(cesta);
			
			int c;
			while((c = inputStream.read()) != -1) {
				System.out.print((char) c);
			}
		} finally {
			if (inputStream != null)
				inputStream.close();
		}
	}
// 1. BufferedReader - cita po riadkoch
	public static void bufferReader(String cesta) throws IOException {
		BufferedReader inputStream = null;
		
		try {
			inputStream = new BufferedReader(new FileReader(cesta));
			
			String s;
			while ((s = inputStream.readLine()) != null) {
				System.out.println(s);
			}
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}
	}

// 2. Prida k textovemu suboru dalsi riadok
	public static void pridajRiadok(String cesta, String text) throws IOException {
		Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(cesta, true), "UTF-8"));
		
		writer.append(text);
		writer.close();
	}
	
	
// 3. Najde najdlhsie slovo z textoveho suboru a vypise ho
	public static void najdiNajdlhsieSlovoVSubore(String cesta) throws IOException {
		FileReader inputStream = null;
		
		try {
			inputStream = new FileReader(cesta);
			
			String najdlhsieSlovo = "", slovo = "";
			int dlzka = 0, dlzkaMax = 0;
			int c;
			while((c = inputStream.read()) != -1) {
				if((char) c != ' ' && (char) c != '\n' && (char) c != '.' && (char) c != ',' && (char) c != '\r') {
					slovo+= (char) c;
					dlzka++;
					if(najdlhsieSlovo.length() < slovo.length()) {
						najdlhsieSlovo = slovo;
						dlzkaMax = dlzka;
					}
				}	
				else {
					slovo = "";
					dlzka = 0;
				}				
			}
			System.out.println("Najdlhsie slovo zo suboru: " + najdlhsieSlovo);
			System.out.println("Dlzka najdlhsieho slova: " + dlzkaMax);
		} finally {
			if (inputStream != null)
				inputStream.close();
		}
	}
	
//	4. Vypise velkost suboru na konzolu
	public static void vypisVelkostSuboru(String cesta) {
		Path path = Paths.get(cesta);
		
		try {
			long bytes = Files.size(path);
			System.out.printf("%d bajtov\n", bytes);
			System.out.printf("%d kilobajtov", bytes / 1024);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

//	5. Zobere String(cestu) a zisti, ci je dany string subor alebo priecinok. Ak je, vypise nazov.
	public static void vypisSuborPriecinok(String cesta) {
		Path path = Paths.get(cesta);
		if(Files.exists(path)) {
			if(Files.isDirectory(path)) {
				System.out.println("String je priecinok");
				System.out.println(path.getFileName());
			}
			else {
				System.out.println("String je subor");
				System.out.println(path.getFileName());
			}
		}
	}


// 6. Zobere String(cestu) a vypise vsetky subory v danom priecinku
	public static void vypisSuboryVPriecinku(String cesta) {
		File f = new File(cesta);
		String[] pathnames;
		
		if(f.isDirectory()) {
			pathnames = f.list();
			for(String s : pathnames) {
				System.out.println(s);
			}
		}
		
		
	}

// 7. Ako argument berie cestu k suboru a dany subor zmaze 
	public static void vymazSubor(String cesta) {
		File f = new File(cesta);
		if(f.isFile()) {
			System.out.println("Zmazal som subor -> " + f.getName());
			f.delete();			
		}
	}

// 8. skopiruje subor z priecinka do druheho priecinku
	public static void skopirujSubor(String subor, String novyPriecinok) throws IOException {
		Path temp = Files.copy(Paths.get(subor), Paths.get(novyPriecinok));
		
		if (temp != null) {
			System.out.println("Uspech, subor bol skopirovany!");
		} else {
			System.out.println("Neuspech, subor nebol skopirovany!");
		}		
	}

// 9. metoda bere nazov suboru a tento subor vytvori
	public static void vytvorSubor(String subor) {
		try {
			File novySubor = new File(subor);
			if(novySubor.createNewFile()) {
				System.out.println("Subor bol vytvoreny! -> " + novySubor.getName());
			} else {
				System.out.println("Subor nebol vytvoreny alebo uz existuje");
			}
		} catch (IOException e) {
			System.out.println("Nastala chyba!");
			e.printStackTrace();
		}
	}
	
// 10. metoda bere nazov suboru a cestu, tento subor vytvori v danej ceste
	public static void vytvorSubor(String subor, String cesta) {
		try {
			File novySubor = new File(cesta + "\\" + subor);
			if(novySubor.createNewFile()) {
				System.out.println("Subor bol vytvoreny! -> " + novySubor.getName());
				System.out.println("Cesta k suboru: " + cesta);
			} else {
				System.out.println("Subor nebol vytvoreny alebo uz existuje");
			}
		} catch (IOException e) {
			System.out.println("Nastala chyba!");
			e.printStackTrace();
		}
	}

}


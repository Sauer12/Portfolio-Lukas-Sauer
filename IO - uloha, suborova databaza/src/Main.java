import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		String cesta = "C:\\Users\\lsaue\\Dropbox\\Programovanie\\Java - 2022\\IO - uloha, suborova databaza\\src";
		String nazovSuboru = "telefonneKontakty.txt";
		
		Kontakt kontakt = new Kontakt("Lenka Sauerová", "0915783002");
		TelefonnyZoznam zoznam = new TelefonnyZoznam(cesta, nazovSuboru);
		zoznam.vytvorSubor();		
		zoznam.pridajKontakt(new Kontakt("Lukáš Sauer", "0917863823", "lsauercv12@gmail.com"));
		zoznam.pridajKontakt(new Kontakt("Lukáš Sauer", "0917863823", "lsauercv12@gmail.com"));
		zoznam.editujCisloPoctuZoznamov();
	}

}

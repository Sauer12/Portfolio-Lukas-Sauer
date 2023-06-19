package fiktivnyProgram.entity;

import main.java.anotacie.Id;
import main.java.anotacie.Stlpec;
import main.java.anotacie.Tabulka;

@Tabulka("OSOBA")
public class Osoba {
	@Id
	@Stlpec("ID")
	private Long id;
	
	@Stlpec("NAME")
	private String meno;
	
	@Stlpec("SURNAME")
	private String priezvisko;
	
	@Stlpec("AGE")
	private int vek;
	
	@Stlpec("ADDRESS")
	private String adresa;
}

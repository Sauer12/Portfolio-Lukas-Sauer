package sk.lukas.sauer;

import java.util.ArrayList;
import java.util.List;

public class Pc {
	
	private Pamat pamat;
	private Procesor procesor;
	private List<Karta> karty = new ArrayList<Karta>();
	private int pocetPamati;
	
	public int getPocetPamati() {
		return pocetPamati;
	}	
}

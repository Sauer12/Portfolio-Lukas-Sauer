package sk.lukas.sauer;

public interface Konfigurovatelny{
	
	void vlozPamat(Pc pc, Pamat... pamate) throws NedostatokMiestaPrePamatoveModuly, NeparnyPocetPamati, PamateNieSuRovnake;
	void vlozProcesor(Pc pc, Procesor procesor);
	void vlozKartu(Pc pc, Karta karta);
	
}

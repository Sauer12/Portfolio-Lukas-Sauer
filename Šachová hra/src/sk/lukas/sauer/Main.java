package sk.lukas.sauer;

import sk.lukas.sauer.figurky.*;

public class Main {
	
	public static void main(String[] args) {
		Pesiak pesiak = new Pesiak(FarbaFigurky.BIELA, TypFigurky.PESIAK);		
		Kon kon = new Kon(FarbaFigurky.BIELA, TypFigurky.KON);
		Strelec strelec = new Strelec(FarbaFigurky.BIELA, TypFigurky.STRELEC);
		Veza veza = new Veza(FarbaFigurky.BIELA, TypFigurky.VEZA);
		Dama dama = new Dama(FarbaFigurky.BIELA, TypFigurky.DAMA);
		Kral kral = new Kral(FarbaFigurky.BIELA, TypFigurky.KRAL);
		
		pesiak.pohybFigurky();
		kon.pohybFigurky();
		strelec.pohybFigurky();
		veza.pohybFigurky();
		dama.pohybFigurky();
		kral.pohybFigurky();
		
	}
}

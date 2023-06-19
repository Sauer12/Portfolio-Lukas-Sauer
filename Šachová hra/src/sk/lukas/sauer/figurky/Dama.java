package sk.lukas.sauer.figurky;

import sk.lukas.sauer.*;

public class Dama extends SachovaFigurka {
	
	public Dama(FarbaFigurky farba, TypFigurky typ) {
		this.farbaFigurky = farba;
		this.typFigurky = typ;
	}
	
	@Override
	public void pohybFigurky() {
		System.out.println("Hybem sa ako Dama.");		
	}

}

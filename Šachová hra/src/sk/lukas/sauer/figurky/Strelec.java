package sk.lukas.sauer.figurky;

import sk.lukas.sauer.*;

public class Strelec extends SachovaFigurka {

	public Strelec(FarbaFigurky farba, TypFigurky typ) {
		this.farbaFigurky = farba;
		this.typFigurky = typ;
	}
	
	@Override
	public void pohybFigurky() {
		System.out.println("Hybem sa ako strelec.");		
	}
	
}

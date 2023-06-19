package sk.lukas.sauer;

public class Konfigurator implements Konfigurovatelny{

	@Override
	public void vlozPamat(Pc pc, Pamat... pamate) throws NedostatokMiestaPrePamatoveModuly, NeparnyPocetPamati, PamateNieSuRovnake {
		int pocetPamati = pamate.length;
		if(pc.getPocetPamati() < pocetPamati) {
			throw new NedostatokMiestaPrePamatoveModuly();
		}
		
		if(pocetPamati > 1) {
			if(pocetPamati % 2 != 0) {
				throw new NeparnyPocetPamati();
			}
		}
		
		String velkostPamate = null;
		for (Pamat pamat : pamate) {
			if(velkostPamate == null) {
				velkostPamate = pamat.getVelkost();
			}
			else {
				if(!velkostPamate.equals(pamat.getVelkost())) {
					throw new PamateNieSuRovnake();
				}
			}
		}
	}

	@Override
	public void vlozProcesor(Pc pc, Procesor procesor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void vlozKartu(Pc pc, Karta karta) {
		// TODO Auto-generated method stub
		
	}
	
}

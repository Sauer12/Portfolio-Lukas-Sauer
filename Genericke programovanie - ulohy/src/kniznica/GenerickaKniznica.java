package kniznica;

import java.util.ArrayList;
import java.util.List;

public class GenerickaKniznica<A extends Medium> {
	
	List<GenerickeMedium> kniznica = new ArrayList<>();
	
	public void pridaj(GenerickeMedium medium) {
		kniznica.add(medium);
	}
	
	public void vypisPolozky() {
		for(GenerickeMedium s : kniznica) {
			System.out.println(s);
		}
	}
	
}

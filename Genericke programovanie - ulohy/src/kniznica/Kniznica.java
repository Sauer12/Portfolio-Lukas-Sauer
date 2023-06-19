package kniznica;

import java.util.ArrayList;
import java.util.List;

public class Kniznica {
	List<Medium> kniznicaMedii = new ArrayList<>();
	
	public void pridajMedium(Medium medium) {
		kniznicaMedii.add(medium);
	}
	
	public void vypisMedia() {
		for(Medium m : kniznicaMedii) {
			System.out.println(m);
		}
	}
}

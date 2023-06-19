/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poznamkovac;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author Luxy
 */
public class Databaza {
    
    private ArrayList<Zaznam> zaznamy;
    
    public Databaza() {
        zaznamy = new ArrayList<>();
    }
    
    public void pridajZaznam(LocalDateTime datumCas, String text) {
            zaznamy.add(new Zaznam(datumCas, text));
    }
    
    public ArrayList<Zaznam> najdiZaznamy(LocalDateTime datum, boolean dleCasu) {
        ArrayList<Zaznam> najdene = new ArrayList();
        for (Zaznam z : zaznamy) {
            if ((dleCasu && z.getDatumCas().equals(datum)) ||
                    (!dleCasu && z.getDatumCas().toLocalDate().equals(datum.toLocalDate()))) {
                najdene.add(z);
            }
        }
        return najdene;
    }
    
    public void vymazZaznamy(LocalDateTime datum) {
        ArrayList<Zaznam> najdene = najdiZaznamy(datum, true);
        for (Zaznam z : najdene) {
            zaznamy.remove(z);
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rozhranie;

import java.util.ArrayList;

/**
 *
 * @author Luxy
 */
public class Rozhranie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Zviera> zvierata = new ArrayList<>();
        zvierata.add(new Vtak(1));
        zvierata.add(new Delfin(8));
        zvierata.add(new Delfin(9));
        zvierata.add(new VtakoJaster(3));
        zvierata.add(new VtakoJaster(2));
        zvierata.add(new Zviera(2) {
            @Override
            public void presunSa() {
                System.out.println("Anonymne sa presuvam");
            }
        });
        
        for (Zviera zviera : zvierata) {
            System.out.println(zviera);
            zviera.dychaj();
            if (zviera instanceof Delfin) {
                ((Delfin)zviera).vyskoc();
            }
        }
        
        
    }
    
}

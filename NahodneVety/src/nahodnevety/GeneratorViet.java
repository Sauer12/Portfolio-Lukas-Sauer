/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nahodnevety;

import java.util.Random;

/**
 *
 * @author Luxy
 */
public class GeneratorViet {
    private Random random;
    private String[] privlastky = {"Modrý", "Veľký", "Hubený", "Najlepší", "Automatizovaný"};
    private String[] podmety = {"jednorožec", "programátor", "manažer", "hroch", "T-rex"};
    private String[] prislovce = {"rýchlo", "s obľubou", "veľa", "málo", "s meškaním"};
    private String[] prisudky = {"spal", "ležal", "varil", "upratoval", "derivoval"};
    private String[] prislovkyMiesta = {"pod stolom", "v lese", "u babičky", "v práci", "na stole"};
    
    public GeneratorViet() {
        random = new Random();
    }
    
    public String generujVetu() {
        return String.format("%s %s %s %s %s", privlastky[this.generujCislo()], podmety[this.generujCislo()], 
                prislovce[this.generujCislo()], prisudky[this.generujCislo()], prislovkyMiesta[this.generujCislo()]);
    }
    
    private int generujCislo() {
        return random.nextInt(5);
    }
    
    
}

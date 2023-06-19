/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ludiax;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Luxy
 */
public class LudiaX {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Clovek>ludia = new ArrayList<>();
        ludia.add(new Muz("Karol", "Novák", LocalDate.parse("1988-05-02")));
        ludia.add(new Muz("Josef", "Nový", LocalDate.parse("1978-03-19")));
        ludia.add(new Muz("Jan", "Marek", LocalDate.parse("1968-04-28")));
        ludia.add(new Muz("Karol", "Novák", LocalDate.parse("1958-06-25")));
        ludia.add(new Zena("Marie", "Nová", LocalDate.parse("1988-08-15")));
        ludia.add(new Zena("Viera", "Nováková", LocalDate.parse("1978-10-02")));
        ludia.add(new Zena("Simona", "Mladá", LocalDate.parse("1968-01-08")));
        ludia.add(new Zena("Michaela", "Marná", LocalDate.parse("1958-12-06")));
        Collections.sort(ludia);
            
        
        for(Clovek n : ludia) {
            System.out.println(n.meno + " " + n.priezvisko + " " + String.valueOf(n.datumNarodenia.getYear()).substring(2, 4));
        }
                
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sucetcifiervdatumoch;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Luxy
 */
public class SucetCifierVDatumoch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("Vypisujem súčty cifier v dátomoch pre nasledujúcich 7 dní.");
        
        for(int i = 0; i < 8; i++) {
            LocalDate datum = LocalDate.now();
            datum = datum.plusDays(i);
            System.out.print(datum.format(DateTimeFormatter.ofPattern("d.M.y - ")));
            int cifernySucet = datum.getYear() + datum.getMonthValue() + datum.getDayOfMonth();
            System.out.println(cifernySucet);
        }
  
        
        
    }
    
}

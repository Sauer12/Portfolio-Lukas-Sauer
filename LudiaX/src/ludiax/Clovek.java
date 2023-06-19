/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ludiax;

import java.time.LocalDate;
import java.util.Random;

/**
 *
 * @author Luxy
 */
public abstract class Clovek implements Comparable{
    
    protected String meno;
    protected String priezvisko;
    protected LocalDate datumNarodenia;
    protected Random random;
    
    public Clovek(String meno, String priezvisko, LocalDate datumNarodenia) {
        this.meno = meno;
        this.priezvisko = priezvisko;
        this.datumNarodenia = datumNarodenia;
        random = new Random();
    }
    
    @Override
    public int compareTo(Object o) {
       Clovek x = (Clovek)o;
       if(this.meno.compareTo(x.meno) >= 1) {
           return 1;
       }
       else if(this.meno.compareTo(x.meno) <= -1) {
           return -1;
       }
       else {
           if(this.datumNarodenia.isAfter(x.datumNarodenia))
               return 1;
           else
               return -1;
       }
    }
    
    public Clovek plus(Clovek other) {
        if((this instanceof Muz && other instanceof Zena) || (this instanceof Zena && other instanceof Muz)) {
            int volba = random.nextInt(2) + 1;
            if(volba == 1)
                return new Muz("Adam", this.priezvisko, LocalDate.now());
            else
                return new Zena("Eva", other.priezvisko, LocalDate.now());
        }
        else
            return null;     
    }
    
    
}

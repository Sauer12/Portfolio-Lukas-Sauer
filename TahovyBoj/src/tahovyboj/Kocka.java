/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tahovyboj;

import java.util.Random;

/** Trieda reprezentuje hraciu kocku */
public class Kocka {
    /** Generator nahodnych cisiel */
    private Random random;
    /** Pocet stien kocky */
    private int pocetStien;
    
    public Kocka() {
        pocetStien = 6;
        random = new Random();
    }
    
    public Kocka(int pocetStien) {
        this.pocetStien = pocetStien;
        random = new Random();
    }
    /**
     * Vrati pocet stien hracej kocky
     * @return pocet stien hracej kocky
     */
    public int vratPocetStien() {
        return pocetStien;
    }
    /**
     * Vykona hod kockou 
     * @return Cislo od 1 do poctu stien
     */
    public int hod() {
        return random.nextInt(pocetStien) + 1;
    }
    
    @Override
    public String toString() {
        return String.format("Kocka s %s stenami", pocetStien);
    }
    
}

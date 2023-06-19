/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automobily;

/**
 *
 * @author Luxy
 */
public class Auto {
    private String spz;
    private String znacka;
    private double cena;
    
    public Auto(String spz, String znacka, double cena) {
        this.spz = spz;
        this.znacka = znacka;
        this.cena = cena;
    }

    /**
     * @return the cena
     */
    public double getCena() {
        return cena;
    }
    
    @Override
    public String toString() {
        return String.format("%s %s, cena: %f", spz, znacka, cena);
    }
    
    
    
}

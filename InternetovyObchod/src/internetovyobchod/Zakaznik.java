/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internetovyobchod;

/**
 *
 * @author Luxy
 */
public class Zakaznik {
    
    private String meno;
    private String priezvisko;
    private int vek;
    private Adresa fakturacnaAdresa;
    private Adresa dodaciaAdresa;
    
    public Zakaznik(String meno, String priezvisko, int vek, Adresa fakturacnaAdresa, Adresa dodaciaAdresa) {
        this.meno = meno;
        this.priezvisko = priezvisko;
        this.vek = vek;
        this.fakturacnaAdresa = fakturacnaAdresa;
        this.dodaciaAdresa = dodaciaAdresa;
    }
    
    
    
    @Override
    public String toString() {
        return String.format("%s %s", getMeno(), getPriezvisko());
    }

    /**
     * @return the meno
     */
    public String getMeno() {
        return meno;
    }

    /**
     * @return the priezvisko
     */
    public String getPriezvisko() {
        return priezvisko;
    }

    /**
     * @return the vek
     */
    public int getVek() {
        return vek;
    }

    /**
     * @return the fakturacnaAdresa
     */
    public Adresa getFakturacnaAdresa() {
        return fakturacnaAdresa;
    }

    /**
     * @return the dodaciaAdresa
     */
    public Adresa getDodaciaAdresa() {
        return dodaciaAdresa;
    }
}

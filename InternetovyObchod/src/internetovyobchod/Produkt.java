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
public class Produkt {
    
    private String nazovProduktu;
    private double cena;
    private String popis;
    
    public Produkt(String nazovProduktu, double cena, String popis) {
        this.nazovProduktu = nazovProduktu;
        this.cena = cena;
        this.popis = popis;
    }
    
    @Override
    public String toString() {
        return String.format("%s, cena %s", getNazovProduktu(), getCena());
    }

    /**
     * @return the nazovProduktu
     */
    public String getNazovProduktu() {
        return nazovProduktu;
    }

    /**
     * @return the cena
     */
    public double getCena() {
        return cena;
    }
}

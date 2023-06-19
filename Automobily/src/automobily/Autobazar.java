/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automobily;

import java.util.ArrayList;

/**
 *
 * @author Luxy
 */
public class Autobazar {
    private String meno;
    private String adresa;
    private double peniaze;
    private ArrayList<Auto> auta;
    
    public Autobazar(String meno, String adresa, double peniaze) {
        this.meno = meno;
        this.adresa = adresa;
        this.peniaze = peniaze;
        auta = new ArrayList<Auto>();
    }
    
    public void odkupAutomobil(String spz, String znacka, double cena) {
        auta.add(new Auto(spz, znacka, cena));
        peniaze -= cena;
    }
    
    public void odkupAutomobil(String spz, String znacka, double cena, float nosnost) {
        auta.add(new NakladneAuto(spz, znacka, cena, nosnost));
        peniaze -= cena;
    }
    
    public void odkupAutomobil(Auto auto) {
        auta.add(auto);
        peniaze -= auto.getCena();
    }
    
    public void predajAuto(Auto auto) {
        auta.remove(auto);
        peniaze += auto.getCena();
    }
    
    public double cenaAutomobilov() {
        double cenaAutomobilov = 0;
        for(Auto auto : auta) {
            cenaAutomobilov += auto.getCena();
        }
        return cenaAutomobilov;
    }
    public int pocetAutomobilov() {
        return auta.size();
    }
    
    /**
     * @return the peniaze
     */
    public double getPeniaze() {
        return peniaze;
    }
    
    @Override
    public String toString() {
        return String.format("Autobazar %s", meno);
    }
}

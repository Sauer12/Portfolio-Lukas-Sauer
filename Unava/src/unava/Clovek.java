/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unava;

/**
 *
 * @author Luxy
 */
public class Clovek {
    private String meno;
    private int vek;
    private int unava;
    
    public Clovek(String meno, int vek) {
        this.meno = meno;
        this.vek = vek;
        unava = 0;
    }
    
    public void bez(int pocetKm) {
        if((unava + pocetKm) > 20)
            System.out.println("Som príliš unavený...");
        else
            unava += pocetKm;
    }
    
    public void spi(int pocetHodin) {
        if ((unava - pocetHodin) < 0)
            System.out.println("Nemôžem spať...");
        else
            unava -= pocetHodin * 10;
    }
    
    @Override
    public String toString() {
        return String.format("%s (%d)", meno, vek);
    }  
}

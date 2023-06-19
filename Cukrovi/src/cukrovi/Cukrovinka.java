/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cukrovi;

/**
 *
 * @author Luxy
 */
public class Cukrovinka {
    private String farba;
    private String tvar;
    private int vaha;
    
    public Cukrovinka(String farba, String tvar, int vaha) {
        this.farba = farba;
        this.tvar = tvar;
        this.vaha = vaha;
    }
    
    @Override
    public String toString() {
        return String.format("Cukrovinka farby %s, tvaru %s a váhy %d", farba, tvar, vaha);
    }
    
    public static Cukrovinka bananova() {
        return new Cukrovinka("žlta", "guľatý", 20);
    }
    
    public static Cukrovinka jahodova() {
        return new Cukrovinka("červená", "guľatý", 15);
    }
    
    public static Cukrovinka cokoladova() {
        return new Cukrovinka("hnedá", "hranatý", 25);
    }
}

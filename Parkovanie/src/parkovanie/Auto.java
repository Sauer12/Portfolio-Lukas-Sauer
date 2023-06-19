/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkovanie;

/**
 *
 * @author Luxy
 */
public class Auto {
    private String spz;
    private String farba;
    
    public Auto(String spz, String farba) {
        this.spz = spz;
        this.farba = farba;
    }
    
    public String getSpz() {
        return spz;
    }
    
    public void zaparkuj(Garaz garaz) {
        garaz.vloz(this);
    }
    
    @Override
    public String toString() {
        return String.format(spz);
    }
}

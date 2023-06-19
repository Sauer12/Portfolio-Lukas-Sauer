/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starnutiepsa;

/**
 *
 * @author Luxy
 */
public class Pes {
    private String meno;
    private int vek;
    
    public Pes(String meno, int vek) {
        this.meno = meno;
        this.vek = vek;
    }
    
    public void zostarni(int pocetRokov) {
        vek += pocetRokov;
    }
    
    @Override
    public String toString() {
        return String.format("%s (%d rokov)", meno, vek);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kamarati;

/**
 *
 * @author Luxy
 */
public class Clovek {
    private String meno;
    private int vek;
    private Clovek kamarat;
    
    public Clovek(String meno, int vek) {
        this.meno = meno;
        this.vek = vek;
    }
    
    public void skamaradSa(Clovek kamarat) {
        this.kamarat = kamarat;
    }
    
    @Override
    public String toString() {
       return String.format("Ahoj, som %s, je mi %d rokov a moj kamarat je %s", meno, vek, kamarat.meno);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vtaci;

/**
 *
 * @author Luxy
 */
public class AngryVtak extends Vtak {
    private int vztek;
    
    public AngryVtak(int hlad, int vaha, int vztek) {
        super(hlad, vaha);
        this.vztek = vztek;
    }
    
    public void provokuj(int provokacia) {
        if(hlad != 0)
            vztek += provokacia * 2;
        else
            vztek += provokacia;
    }
    
    @Override
    public String toString() {
        return String.format("Som angry-vtak s váhou %d a hladom %d, miera môjho vzteku je %d", vaha, hlad, vztek);
    }
    
    
}

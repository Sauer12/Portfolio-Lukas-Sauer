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
public class Vtak {
    protected int hlad;
    protected int vaha;
    
    public Vtak(int hlad, int vaha){
        this.hlad = hlad;
        this.vaha = vaha;
    }
    
    public void zjedz(int vaha){  
        this.vaha += vaha;
        if(hlad >= vaha)
            hlad -= vaha;
        else
            hlad = 0;
    }
    
    @Override
    public String toString() {
        return String.format("Som vtak s váhou %d a hladom %d", vaha, hlad);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nastroje;

/**
 *
 * @author Luxy
 */
public class ElektrickySrubovak extends Srubovak {
    
    private int kapacitaBaterie;
    
    public ElektrickySrubovak(int vaha, String nazov, int kapacitaBaterie) {
        super(vaha, nazov);
        this.kapacitaBaterie = kapacitaBaterie;
    }
    
    @Override
    public String pracuj() {
        return String.format("Elektricky šrubujem"); 
    }
}

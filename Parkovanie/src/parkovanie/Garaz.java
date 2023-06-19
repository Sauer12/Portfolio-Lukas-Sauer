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
public class Garaz {
    public Auto auto;
    
    public void vloz(Auto auto) {
        this.auto = auto;
    }
    
    @Override
    public String toString() {
        return String.format("V garáži je auto: %s", auto.getSpz());
    }
    
}

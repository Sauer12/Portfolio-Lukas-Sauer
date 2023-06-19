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
public class Srubovak extends Nastroj {
    
    public Srubovak(int vaha, String nazov) {
        this.vaha = vaha;
        this.nazov = nazov;
    }
    
    @Override
    public String pracuj() {
        return String.format("Šrubujem"); //To change body of generated methods, choose Tools | Templates.
    }
}

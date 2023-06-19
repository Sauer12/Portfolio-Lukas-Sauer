/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automobily;

/**
 *
 * @author Luxy
 */
public class NakladneAuto extends Auto{
    private float nosnost;
    
    public NakladneAuto(String spz, String znacka, double cena, float nosnost) {
        super(spz, znacka, cena);
        this.nosnost = nosnost;
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piesok;

/**
 *
 * @author Luxy
 */
public class NakladneAuto {
    
    private int nosnost;
    private int naklad;
    
    public NakladneAuto(int nosnost) {
        this.nosnost = nosnost;
        naklad = 0;
    }
    
    public void Naloz(int hmotnost) {
        if((naklad + hmotnost) <= nosnost) {
            naklad += hmotnost;
        }   
    }
    
    public void Vyloz(int hmotnost) {
        if(hmotnost <= naklad) {
            naklad -= hmotnost;
        }
    }
    
    public int getNaklad() {
        return naklad;
    }
    
}

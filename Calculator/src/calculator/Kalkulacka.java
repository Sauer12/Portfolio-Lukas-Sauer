/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

/**
 *
 * @author Luxy
 */
public class Kalkulacka {
    public float cisloX;
    public float cisloY;
    
    public float scitanie() {
        return cisloX + cisloY;
    }
    
    public float odcitanie() {
        return cisloX - cisloY;
    }
    
    public float nasobenie() {
        return cisloX * cisloY;
    }
    
    public float delenie() {
        if(!(cisloY == 0)) {
            return cisloX / cisloY;
        }
        else
            return -1;
    }
}

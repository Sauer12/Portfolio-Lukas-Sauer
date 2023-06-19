/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strom;

/**
 *
 * @author Luxy
 */
public class Obdlznik extends Tvar {
    private float sirka;
    private float vyska;
    
    
    public Obdlznik(String farba, float sirka, float vyska) {
        super(farba);
        this.sirka = sirka;
        this.vyska = vyska;
    }
    
    public float obsah() {
        return sirka * vyska;
    }
    
    public float obvod() {
        return 2 * (sirka + vyska);
    }
}

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
public class Trojuholnik extends Tvar{
    private float a;
    private float b;
    private float c;
    
    public Trojuholnik(String farba, float a, float b, float c) {
        super(farba);
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public double obsah() {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
    
    public float obvod() {
        return a + b + c;
    }
}

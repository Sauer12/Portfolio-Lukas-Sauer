/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slova;

import java.util.ArrayList;

/**
 *
 * @author Luxy
 */
public class SlovaList {
    ArrayList<String> slova;
    
    public SlovaList() {
        slova = new ArrayList<String>();
    }
    
    public void pridajSlovo(String s) {
        slova.add(s);
    }
    
    public void vypisSlova() {
        System.out.println("Zadal jsi tato slova: " + String.join(", ", slova));
    }
    
    
}
    
    

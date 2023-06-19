/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package losovaniex;

import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
/**
 *
 * @author Luxy
 */
public class Losovac {
    private ArrayList<Integer> cisla;
    private Random random;
    
    public Losovac() {
        random = new Random();
        cisla = new ArrayList<Integer>();
    }
    
    public int losuj() {
        int cislo = random.nextInt(100) + 1;
        cisla.add(cislo);
        return cislo;
    }
    
    public String vypis() {
        String s = "";
        Collections.sort(cisla);
        for (int i : cisla) {
            s += i + " ";
        }
        return s;
    }
}

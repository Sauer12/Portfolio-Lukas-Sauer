/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prevodstupnov;

/**
 *
 * @author Luxy
 */
public class Prevod {
    
    public static double prevedNaRadiany(double stupne) {
        return stupne * Math.PI / 180;
    }
    
    public static double prevedNaStupne (double radiany) {
        return radiany * 180 / Math.PI;
    }
    
}

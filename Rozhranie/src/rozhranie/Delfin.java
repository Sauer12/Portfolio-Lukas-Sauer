/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rozhranie;

/**
 *
 * @author Luxy
 */
public class Delfin extends Zviera {
    
    public Delfin(int vaha) {
        super(vaha);
    }
    
    public void vyskoc() {
        System.out.println("Vyskocil som nad hladinu...");
    }
    
    @Override
    public void presunSa() {
        System.out.println("Plavem...");
    }
}
        
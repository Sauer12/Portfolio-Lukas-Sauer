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
public class Vtak extends Zviera implements VtakInterface {
    
    public Vtak(int vaha) {
        super(vaha);
    }
    
    @Override
    public void pipni() {
        System.out.println("la la la");
    }
    
    
    public void klovni() {
        System.out.println("Klov, klov!");
    }
    
    @Override
    public void presunSa() {
        System.out.println("Letim...");
    }
}

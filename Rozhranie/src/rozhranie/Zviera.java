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
public abstract class Zviera implements Comparable {
    private int vaha;
    
    public Zviera(int vaha) {
        this.vaha = vaha;
    }
    
    public int getVaha() {
        return vaha;
    }
    
    public void setVaha(int vaha) {
        this.vaha = vaha;
    }
    
    public abstract void presunSa();
    
    public void dychaj() {
        System.out.println("Dycham...");
    }
    
    @Override
    public int compareTo(Object o) {
        Zviera ine = (Zviera)o;
        if (this.vaha < ine.vaha) {
            return -1;
        }
        if (this.vaha > ine.vaha) {
            return 1;
        }
        return 0;
    }
    
    @Override
    public String toString() {
        return String.format("Som zviera a mam " + vaha + " kg");
    }
}

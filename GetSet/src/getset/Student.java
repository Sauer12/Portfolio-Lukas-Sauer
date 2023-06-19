/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getset;

/**
 *
 * @author Luxy
 */
public class Student {
    public String meno;
    public boolean muz;
    public int vek;
    public boolean plnolety;
    
    public Student(String meno, boolean muz, int vek) {
        this.meno = meno;
        this.muz = muz;
        this.vek = vek;
        plnolety = true;
        if (vek < 18) {
            plnolety = false;
        }
    }
    
    @Override
    public String toString() {
        String somPlnolety = "som";
        if (!plnolety) {
            somPlnolety = "niesom";
        }
        String pohlavie = "muž";
        if (!muz) {
            pohlavie = "žena";
        }
        return String.format("Som %s, %s. Je mi %d rokov a %s plnoletý.", meno, pohlavie, vek, somPlnolety);
    }
}

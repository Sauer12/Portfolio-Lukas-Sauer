/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ludia;

/**
 *
 * @author Luxy
 */
public class Clovek {
    private String meno;
    private int vek;
    protected int unava = 0;
    
    public Clovek(String meno, int vek) {
        this.meno = meno;
        this.vek = vek;
    }
    
    public void spi(int doba) {
        unava -= doba *10;
        if (unava < 0)
            unava = 0;
    }
    
    public void behaj(int vzdialenost) {
        if (unava + vzdialenost <= 20)
            unava += vzdialenost;
        else
            System.out.println("Som príliš unavený");
    }
    
    @Override
    public String toString() {
        return String.format("%s (%d)", meno, vek);
    }
}

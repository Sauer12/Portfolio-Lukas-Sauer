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
public class Javista extends Clovek{
    private String ide;
    
    public Javista(String meno, int vek, String ide) {
        super(meno, vek);
        this.ide = ide;
    }
    
    public void programuj(int pocetRiadkov) {
        double pocet = Math.ceil((double)pocetRiadkov / 10);
        for(int i = 1; i <= (int)pocet; i++) {
            if(unava >= 20) {
                System.out.println("Som príliš unavený");
                break;
            }
            else
                unava += 1;
        }
    }
    
    
}

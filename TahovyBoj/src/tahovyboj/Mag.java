/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tahovyboj;

/**
 *
 * @author Luxy
 */
public class Mag extends Bojovnik {
    private int mana;
    private int maxMana;
    private int magickyUtok;
    
    public Mag(String meno, int zivot, int utok, int obrana, Kocka kocka, int mana, int magickyUtok) {
        super(meno, zivot, utok, obrana, kocka);
        this.mana = mana;
        this.maxMana = mana;
        this.magickyUtok = magickyUtok;
    }
    
    @Override
    public void utoc(Bojovnik souper) {
        //Mana neni naplnena
        if (mana < maxMana) {
            mana += 10;
            if (mana > maxMana) {
                mana = maxMana;
            }
            souper.utoc(souper);
        }
        else {
            int uder = magickyUtok + kocka.hod();
            nastavSpravu(String.format("%s pouzil magiu za %s hp", meno, uder));
            souper.branSa(uder);
            mana = 0;
        }
    }
    
    public String grafickaMana() {
        return grafickyUkazatel(mana, maxMana);
    }
}

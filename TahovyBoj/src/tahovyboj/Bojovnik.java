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
public class Bojovnik {
    /** Meno bojovnika */
    protected String meno;
    /** Zivot v HP */
    protected int zivot;
    /** Maximalne zdravie */
    protected int maxZivot;
    /** Utok v HP */
    protected int utok;
    /** Obrana v HP */
    protected int obrana;
    /** Instancia hracej kocky */
    protected Kocka kocka;
    /** Vypis spravy */
    private String sprava;
   
    
    
    public Bojovnik(String meno, int zivot, int utok, int obrana, Kocka kocka) {
        this.meno = meno;
        this.zivot = zivot;
        this.maxZivot = zivot;
        this.utok = utok;
        this.obrana = obrana;
        this.kocka = kocka;
    }
    
    public void branSa(int uder) {
        int zranenie = uder - (obrana + kocka.hod());
        if (zranenie > 0) {
            zivot -= zranenie;
            sprava = String.format("%s utrpel poskodenie %s hp", meno, zranenie);
            if (zivot <= 0) {
                zivot = 0;
                sprava += " a zomrel";
            }
        }
        else
            sprava = String.format("%s odrazil utok", meno);
        nastavSpravu(sprava);
    }
    
    public void utoc(Bojovnik souper) {
        int uder = utok + kocka.hod();
        nastavSpravu(String.format("%s utoci s uderom za %s hp", meno, uder));
        souper.branSa(uder);
    }
    
    public String grafickyZivot() {
        return grafickyUkazatel(zivot, maxZivot);
    }
    
    
    protected String grafickyUkazatel(int aktualny, int maximalny) {
        String s = "[";
        int celkom = 20;
        double pocet = Math.round(((double)aktualny / maximalny) * celkom);
        if ((pocet == 0) && (nazivu())) {
            pocet = 1;
        }
        for (int i = 0; i < pocet; i++) {
            s += "#";
        }
            s = String.format("%1$-" + (celkom + 1) + "s", s);
        s += "]";
        return s;
    }
    
    public boolean nazivu() {
        return (zivot > 0);
    }
    
    protected void nastavSpravu(String sprava) {
        this.sprava = sprava;
    }
    
    public String vratPoslednuSpravu() {
        return sprava;
    }
    
    @Override
    public String toString() {
        return meno;
    }
}

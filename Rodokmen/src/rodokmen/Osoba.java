/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rodokmen;

/**
 *
 * @author Luxy
 */
public class Osoba {
    
    private String meno;
    private Osoba otec;
    private Osoba matka;
    
    public Osoba(){    
    };
    
    public Osoba(String meno) {
        this.meno = meno;
    }
    
    public Osoba(String meno, Osoba otec, Osoba matka) {
        this.meno = meno;
        this.otec = otec;
        this.matka = matka;
    }
    
    public void setOtec(Osoba otec) {
        this.otec = otec;
    }
    
    public void setMatka(Osoba matka) {
        this.matka = matka;
    }
    
    @Override
    public String toString() {
        if(otec != null && matka != null)
            return String.format("%s\n%s\n%s", meno, otec, matka);
        else
            return meno;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textovahra;

/**
 *
 * @author Luxy
 */
public class Lokacia {
    private String nazov;
    private String popis;
    private Lokacia sever;
    private Lokacia vychod;
    private Lokacia juh;
    private Lokacia zapad;
    
    public Lokacia(String nazov, String popis, Lokacia sever, Lokacia vychod, Lokacia juh, Lokacia zapad) {
        this.nazov = nazov;
        this.popis = popis;
        this.sever = sever;
        this.vychod = vychod;
        this.juh = juh;
        this.zapad = zapad;              
    } 
    
    public void setLokaciaSever(Lokacia Sever) {
        this.sever = Sever;
    }
    
    public Lokacia getLokaciaSever(){
        return sever;
    }
    
    public void setLokaciaVychod(Lokacia Vychod) {
        this.vychod = Vychod;
    }
    
     public Lokacia getLokaciaVychod(){
        return vychod;
    }
    
    public void setLokaciaJuh(Lokacia Juh) {
        this.juh = Juh;
    }
    
     public Lokacia getLokaciaJuh(){
        return juh;
    }
    
    public void setLokaciaZapad(Lokacia Zapad) {
        this.zapad = Zapad;
    }
    
    public Lokacia getLokaciaZapad(){
        return zapad;
    }
    
    public String moznosti() {
        String s = "Môžeš ísť na ";
        if(sever != null)
            s += "sever ";
        if(vychod != null)
            s += "východ ";
        if(juh != null)
            s += "juh ";
        if(zapad != null)
            s += "zapad ";
        return s;
    }
       
    @Override
    public String toString() {
        return String.format("%s\n%s\n", nazov, popis);
    }
}
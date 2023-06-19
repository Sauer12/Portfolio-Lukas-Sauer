/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singleton;

/**
 *
 * @author Luxy
 */
public class Databaza {
    
    private static Databaza instancia = null;
    private String meno = "";
    
    private Databaza(String meno) 
    {
        this.meno = meno;
    }
    
    public String getMeno() {
        return meno;
    }
    
    public void setMeno(String meno) {
        this.meno = meno;
    } 
    
    public static Databaza vratInstanciu() {
        if (instancia == null)
            instancia = new Databaza("SQL");
        return instancia;
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internetovyobchod;

/**
 *
 * @author Luxy
 */
public class Adresa {
    private String psc;
    private String nazovUlice;
    private String mesto;
    private int cislo;
    private int registryNumber;
    private String krajina;
    
    public Adresa(String psc, String nazovUlice, String mesto, int cislo, int registryNumber, String krajina) {
        this.psc = psc;
        this.nazovUlice = nazovUlice;
        this.mesto = mesto;
        this.cislo = cislo;
        this.registryNumber = registryNumber;
        this.krajina = krajina;
    }
    
    @Override
    public String toString() {
        return String.format("%s %s, %s", getNazovUlice(), getCislo(), getPsc());
    }

    /**
     * @return the psc
     */
    public String getPsc() {
        return psc;
    }

    /**
     * @return the nazovUlice
     */
    public String getNazovUlice() {
        return nazovUlice;
    }

    /**
     * @return the mesto
     */
    public String getMesto() {
        return mesto;
    }

    /**
     * @return the cislo
     */
    public int getCislo() {
        return cislo;
    }

    /**
     * @return the registryNumber
     */
    public int getRegistryNumber() {
        return registryNumber;
    }

    /**
     * @return the krajina
     */
    public String getKrajina() {
        return krajina;
    }
    
    
}

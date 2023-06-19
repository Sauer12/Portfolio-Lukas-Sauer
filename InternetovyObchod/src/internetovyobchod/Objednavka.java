/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internetovyobchod;

import java.util.ArrayList;

/**
 *
 * @author Luxy
 */
public class Objednavka implements OrderInterface {
    
    public Produkt produkt;
    public Zakaznik zakaznik;
    public int idObjednavky;
    
    public Objednavka(Produkt produkt, Zakaznik zakaznik, int idObjednavky) {
        this.produkt = produkt;
        this.zakaznik = zakaznik;
        this.idObjednavky = idObjednavky;
    }
    
    @Override
    public String toString() {
        return String.format("%d", idObjednavky);
    }

    @Override
    public int getNumber() {
        return idObjednavky; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getFirstName() {
        return zakaznik.getMeno(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getLastName() {
        return zakaznik.getPriezvisko(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getStreet() {
        return zakaznik.getFakturacnaAdresa().getNazovUlice(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getHouseNumber() {
        return zakaznik.getFakturacnaAdresa().getCislo(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getRegistryNumber() {
        return zakaznik.getFakturacnaAdresa().getRegistryNumber(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getCity() {
        return zakaznik.getFakturacnaAdresa().getMesto(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getZipCode() {
        return zakaznik.getFakturacnaAdresa().getPsc(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getCountry() {
        return zakaznik.getFakturacnaAdresa().getKrajina(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> getProducts() {
        ArrayList<String>produkty = new ArrayList();
        produkty.add(produkt.getNazovProduktu());
        return produkty;
    }

    @Override
    public ArrayList<Integer> getProductQuantities() {
        ArrayList<Integer>pocet = new ArrayList();
        pocet.add(1);
        return pocet;
    }

    @Override
    public ArrayList<Double> getProductPrices() {
        ArrayList<Double>cena = new ArrayList();
        cena.add(produkt.getCena());
        return cena;
    }
}

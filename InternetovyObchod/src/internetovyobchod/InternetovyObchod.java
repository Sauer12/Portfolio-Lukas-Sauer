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
public class InternetovyObchod {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            Adresa adresa = new Adresa("044 20", "Tulipánová", "Malá Ida", 37, 390, "Slovenská republika");
            Zakaznik zakaznik = new Zakaznik("Lukáš", "Sauer", 21, adresa, adresa);
            Produkt produkt = new Produkt("Body pre ITnetwork.cz", 239, "Body pro zpřístupnění prémiového obsahu a dosažení vašeho vysněného zaměstnání v IT.");
            Objednavka objednavka = new Objednavka(produkt, zakaznik, 1);
            
            Gateway brana = new Gateway();
            brana.processOrder(objednavka);
    }
    
}

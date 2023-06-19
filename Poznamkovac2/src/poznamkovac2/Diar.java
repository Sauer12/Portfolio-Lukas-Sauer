/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poznamkovac2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Luxy
 */
public class Diar {
    
    public static final DateTimeFormatter FORMAT_DATA = DateTimeFormatter.ofPattern("d'.'M'.'y H:mm");
    public static final DateTimeFormatter FORMAT_DATA_BEZ_CASU = DateTimeFormatter.ofPattern("d'.'M'.'y");
    private Databaza databaza;
    private Scanner sc = new Scanner(System.in, "Windows-1250");
    
    public Diar() {
        databaza = new Databaza();
    }
    
    private LocalDateTime zistiDatumCas() {
        System.out.println("Zadajte datum a čas v tvare [1.1.2013 14:00]:");
        while (true) {
            try {
                return LocalDateTime.parse(sc.nextLine(), FORMAT_DATA);
            } catch (Exception ex) {
                System.out.println("Nespravne zadanie, zadajte prosim znovu");
            }
        }
    }
    
    private LocalDateTime zistiDatum() {
        System.out.println("Zadajte datum v tvare [1.1.2013]");
        while (true) {
            try {
                return LocalDate.parse(sc.nextLine(), FORMAT_DATA_BEZ_CASU).atStartOfDay();
            } catch (Exception ex) {
                System.out.println("Nespravne zadanie, zadajte prosim znova");
            }
        }
    }
    
    public void vypisZaznamy(LocalDateTime den) {
        ArrayList<Zaznam> zaznamy = databaza.najdiZaznamy(den, false);
        for(Zaznam z : zaznamy) {
            System.out.println(z);
        }
    }
    
    public void pridajZaznam() {
        LocalDateTime datumCas = zistiDatumCas();
        System.out.println("Zadajte text zaznamu");
        String text = sc.nextLine();
        databaza.pridajZaznam(datumCas, text);
    }
    
    public void vyhladajZaznamy() {
        LocalDateTime datumCas = zistiDatum();
        ArrayList<Zaznam> zaznamy = databaza.najdiZaznamy(datumCas, false);
        if (zaznamy.size() > 0) {
            System.out.println("Boli najdene tieto zaznamy: ");
            for (Zaznam z : zaznamy) {
                System.out.println(z);
            }
        } 
        else {
            System.out.println("Neboli najdene ziadne zaznamy");
        }
    }
    
    public void vymazZaznamy() {
        System.out.println("Budu vymazane zaznamy v dany den a hodinu");
        LocalDateTime datumCas = zistiDatumCas();
        databaza.vymazZaznamy(datumCas);
    }
    
    public void vypisUvodnuObrazovku() {
        System.out.println();
        System.out.println();
        System.out.println("Vitajte v diari!");
        LocalDateTime dnes = LocalDateTime.now();
        System.out.printf("Dnes je: %s\n", FORMAT_DATA.format(dnes));
        System.out.println();
        
        System.out.println("Dnes:\n------");
        vypisZaznamy(dnes);
        System.out.println();
        System.out.println("Zajtra:\n------");
        LocalDateTime zajtra = LocalDateTime.now().plusDays(1);
        vypisZaznamy(zajtra);
        System.out.println();
    }
}

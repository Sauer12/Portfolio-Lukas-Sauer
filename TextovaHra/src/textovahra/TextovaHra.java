/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textovahra;

import java.util.Scanner;

/**
 *
 * @author Luxy
 */
public class TextovaHra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "Windows-1250");
        
        Lokacia dom = new Lokacia("Dom", "Stojíš před svým rodným domem, cítíš vůni čerstvě nasekaného dřeva, která se line\n" +
"z hromady vedle vstupních dveří.", null, null, null, null);
        Lokacia les1 = new Lokacia("Les", "Jsi na lesní cestě, která se klikatí až za obzor, kde mizí v siluetě zapadajícího\n" +
"slunce. Ticho podvečerního lesa občas přeruší zpěv posledních ptáků.", null, dom, null, null);
        Lokacia rozcestie = new Lokacia("Lesné rozcestie", "Nacházíš se na lesním rozcestí.", null, null, les1, null);
        Lokacia les2 = new Lokacia("Les", "Jsi na lesní cestě, která se klikatí až za obzor, kde mizí v siluetě zapadajícího\n" +
"slunce. Ticho podvečerního lesa občas přeruší zpěv posledních ptáků.", null, rozcestie, null, null);
        Lokacia hrad = new Lokacia("Hrad", "Stojíš před okovanou branou gotického hradu, která je zřejmě jediným vchodem do pevnosti.\n" +
"Klíčová dírka je pokryta pavučinami, což vzbuzuje dojem, že je budova opuštěná.", null, les2, null, null);
        Lokacia les3 = new Lokacia("Les", "Jsi na lesní cestě, která se klikatí až za obzor, kde mizí v siluetě zapadajícího\n" +
"slunce. Ticho podvečerního lesa občas přeruší zpěv posledních ptáků.", null, null, null, rozcestie);
        Lokacia rybnik = new Lokacia("Rybnik", "Došel jsi ke břehu malého rybníka. Hladina je v bezvětří jako zrcadlo. Kousek\n" +
"od tebe je dřevěná plošina se stavidlem.", null, null, null, les3);
        Lokacia aktualnaLokacia = dom;
        
        dom.setLokaciaZapad(les1);
        les1.setLokaciaSever(rozcestie);
        les2.setLokaciaZapad(hrad);
        les3.setLokaciaVychod(rybnik);
        rozcestie.setLokaciaVychod(les3);
        rozcestie.setLokaciaZapad(les2);
        
        boolean koniec = false;
        String volba = "";
        
        while(!koniec) {
            System.out.println(aktualnaLokacia);
            System.out.println(aktualnaLokacia.moznosti());
   
            System.out.print("Zadaj príkaz:");
            volba = sc.nextLine().toLowerCase().trim();
            if(volba.equals("chod na sever") && aktualnaLokacia.getLokaciaSever() != null) {
                aktualnaLokacia = aktualnaLokacia.getLokaciaSever();
            }
            else if(volba.equals("chod na vychod") && aktualnaLokacia.getLokaciaVychod() != null) {
                aktualnaLokacia = aktualnaLokacia.getLokaciaVychod();
            }
            else if(volba.equals("chod na juh") && aktualnaLokacia.getLokaciaJuh() != null) {
                aktualnaLokacia = aktualnaLokacia.getLokaciaJuh();
            }
            else if(volba.equals("chod na zapad") && aktualnaLokacia.getLokaciaZapad() != null) {
                aktualnaLokacia = aktualnaLokacia.getLokaciaZapad();
            }
            else if(volba.equals("koniec")) {
                koniec = true;
            }
            else
                System.out.println("Neplatná voľba!\n");           
        }  
        
        
    }
       
    
}
   
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strings;

import java.util.Scanner;
/**
 *
 * @author Luxy
 */
public class Strings {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "Windows-1250");
        String s = "Krokonosohroch";
        System.out.println(s.startsWith("krok"));
        System.out.println(s.endsWith("hroch"));
        System.out.println(s.contains("nos"));
        System.out.println(s.contains("hroh"));
        
        String konfig = "Fullscreen shaDows autosave";
        konfig = konfig.toLowerCase();
        System.out.println("Pobezi hra vo fullscreenu?");
        System.out.println(konfig.contains("fullscreen"));
        System.out.println("Budu zapnute tiene?");
        System.out.println(konfig.contains("shadows"));
        System.out.println("Praje si hrac vypnut zvuky?");
        System.out.println(konfig.contains("nosound"));
        System.out.println("Praje si hrac hru automaticky ukladat?");
        System.out.println(konfig.contains("autosave"));
        
        System.out.println("Zadajte cislo: ");
        String ss = sc.nextLine();
        System.out.println("Zadali ste text: " + ss);
        System.out.println("Text po funkcii trim: " + ss.trim());
        int aa = Integer.parseInt(ss.trim());
        System.out.println("Previedli ste zadany text na cislo parsovanim, zadali ste: " + aa);
        
        String sss = "C# je najlepsi";
        sss = sss.replace("C#", "Java");
        System.out.println(sss);
        
        int a = 10;
        int b = 20;
        int c = a + b;
        String ssss = String.format("Ked scitame %d a %d, dostaneme %d", a, b, c);
        System.out.println(ssss);
        
        System.out.println("Zadajte vase meno: ");
        String meno = sc.nextLine();
        System.out.printf("Dlzka vaseho mnea je: %d", meno.length());
        
    }
    
}

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
public class Rodokmen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Osoba bart = new Osoba("Bart Simpson");
        Osoba homer = new Osoba("Homer Simpson");
        Osoba marge = new Osoba("Marge Bouvier");
        Osoba abraham = new Osoba("Abraham Simpson");
        Osoba penelope = new Osoba("Penelope Olsen");
        Osoba bouvier = new Osoba("Pan Bouvier");
        Osoba jackie = new Osoba("Jackie Bouvier");
        bart.setMatka(marge);
        bart.setOtec(homer);
        homer.setMatka(penelope);
        homer.setOtec(abraham);
        marge.setMatka(jackie);
        marge.setOtec(bouvier);
        
        System.out.println("Rodokmeň pre osobu Bart Simpson");
        System.out.println(bart + "\n");
        System.out.println("Rodokmeň pre osobu Homer Simpson");
        System.out.println(homer);
                
    }
    
}

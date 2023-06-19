/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgbreak;

/**
 *
 * @author Luxy
 */
public class Break {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] zoznamOvocia = {"Jablka", "Hrušky", "Švestky", "Meruňky", "Jahody", "Třešně"};
        int hladanyIndex = -1;
        
        for (int i = 0; i < zoznamOvocia.length; i++) {
            if (zoznamOvocia[i].length() > 6) {
                hladanyIndex = i;
                break;
            }
        }
        
        if (hladanyIndex >= 0)
            System.out.println("Prve slovo dlhsie ako 6 znakov: " + zoznamOvocia[hladanyIndex]);
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cezarovasifra;

/**
 *
 * @author Luxy
 */
public class CezarovaSifra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s = "cernediryjsoutamkdebuhdelilnulou";
        System.out.printf("Povodna sprava %s\n", s);
        String sprava = "";
        int posun = 1;
        
        for (char c : s.toCharArray()){
            int i = (int)c;
            
            if (i > (int)'z'){
                i -= 26;
            }
            i += posun;
            char znak = (char)i;
            sprava += znak;
        }
        
        System.out.printf("Zasifrovana sprava: %s\n", sprava);
        
        String sprava2 = "";
        posun = 1;
        for (char c : sprava.toCharArray()){
            int i = (int)c;
            
            if (i < (int)'a'){
                i += 26;
            }
            i -= posun;
            char znak = (char)i;
            sprava2 += znak;
        }
        
        System.out.printf("Desifrovana sprava: %s\n", sprava2);
        
    }
    
}

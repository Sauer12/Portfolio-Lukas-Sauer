/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dekodermorseovky;

/**
 *
 * @author Luxy
 */
public class DekoderMorseovky {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String s = ".. - -. . - .-- --- .-. -.-";
        System.out.printf("Povodna sprava: %s\n", s);
        String sprava = "";
        
        
        String abecedneZnaky = "abcdefghijklmnopqrstuvwxyz";
        String[] morseoveZnaky = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....",
"..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-",
"...-", ".--", "-..-", "-.--", "--.."};
        String[] znaky = s.split(" ");
    
        for (String morseovZnak : znaky) {
            char abecednyZnak = '?';
            
            int index = -1;
            for (int i = 0; i < morseoveZnaky.length; i++)
            {
                if(morseoveZnaky[i].equals(morseovZnak))
                    index = i;
            }
            
            if (index >= 0) {
                abecednyZnak = abecedneZnaky.charAt(index);
            }
            sprava += abecednyZnak;
        }
        
        System.out.printf("Dekódovaná správa: %s\n", sprava);
    
    }     
}
    
}

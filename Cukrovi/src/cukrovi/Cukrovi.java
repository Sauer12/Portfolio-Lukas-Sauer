/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cukrovi;

/**
 *
 * @author Luxy
 */
public class Cukrovi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cukrovinka[] tovarna = new Cukrovinka[25]; 
        
        for(int i = 0; i < tovarna.length; i++) 
            if(i < 5)
                tovarna[i] = Cukrovinka.bananova(); 
            else if (i > 4 && i < 13)
                tovarna[i] = Cukrovinka.jahodova();
            else
                tovarna[i] = Cukrovinka.cokoladova();
        
        for (Cukrovinka cukrovinka : tovarna) {
            System.out.println(cukrovinka);
        }
        
    }       
}   

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package podmienky2;

/**
 *
 * @author Luxy
 */
public class Podmienky2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean muz = true;
        String nazovPohlavia = (muz) ? "muž" : "žena";
        System.out.println(nazovPohlavia);
        
        int mesiac = 11;
        switch(mesiac) {
            case 1:
            case 2:
            case 3:
                System.out.println("Je prve stvorletie");
                break;
            case 4:
            case 5:
            case 6:
                System.out.println("Je druhe stvorletie");
                break;
            case 7:
            case 8:
            case 9:
                System.out.println("Je tretie stvorletie");
                break;
            case 10:
            case 11:
            case 12:
                System.out.println("je stvrte stvorletie");
                break;
                
               
               
        }
        
        
    }
    
}

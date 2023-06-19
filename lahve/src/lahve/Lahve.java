/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lahve;

/**
 *
 * @author Luxy
 */
public class Lahve {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        for(int lahve = 10; lahve>0; lahve--){
            if(lahve > 4)
                System.out.println(lahve + " zelených láhví stojí na stole a jedna spadne");           
            else if(lahve > 1 && lahve < 5 )
                System.out.println(lahve + " zelené láhve stoja na stole a jedna spadne");
            else
                System.out.println(lahve + " zelená lahev stojí na stole a jedna láhev spadne");
        }
        
        // TODO code application logic here
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nastroje;

/**
 *
 * @author Luxy
 */
public class Nastroje {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Bedna bedna = new Bedna(10000);
        bedna.vypisObsah();
        bedna.pridajNastroj(new Kladivo(1200, "Kladivko", false));
        bedna.pridajNastroj(new Kladivo(3000, "Veľké kladivo", true));
        bedna.pridajNastroj(new Kladivo(4000, "Búracie kladivo", true));
        bedna.pridajNastroj(new Srubovak(800, "Šrubovák Philips"));
        bedna.pridajNastroj(new Pila(2500, "Zrezivelá pila"));
        bedna.pridajNastroj(new ElektrickySrubovak(1800, "Elektrický šrubovák Bosh", 1000));
        bedna.vypisObsah();
        bedna.pracujte();
        bedna.hmotnostObojrucnychKladiv();
        
    }
    
}

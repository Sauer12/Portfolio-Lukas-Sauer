/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nastroje;

import java.util.ArrayList;

/**
 *
 * @author Luxy
 */
public class Bedna {
    
    private int maximalnaVaha;
    private int vahaNaradia;
    private ArrayList<Nastroj> nastroje;
    
    public Bedna(int maximalnaVaha) {
        this.maximalnaVaha = maximalnaVaha;
        nastroje = new ArrayList<>();
    }
    
    public void pridajNastroj(Nastroj nastroj) {
        if(vahaNaradia + nastroj.vaha <= maximalnaVaha) {
            nastroje.add(nastroj);
            vahaNaradia += nastroj.vaha;
        }
        else
            System.out.println("Nastroj sa nepodarilo pridať do bedne!");
    }
    
    public void odoberNastroj(Nastroj nastroj) {
        if(nastroje.equals(nastroj)) {
            nastroje.remove(nastroj);   
            vahaNaradia -= nastroj.vaha;
        }
        else
            System.out.println("Nastroj sa nenachádza v bedni.");
    }
    
    public void pracujte() {
        for(Nastroj n : nastroje) {    
            System.out.println(n.pracuj());
        }
    }
    
    public void vypisObsah() {
        if(!nastroje.isEmpty()) {
            for(int i = 0; i < nastroje.size(); i++) {
                System.out.print(nastroje.get(i).nazov);
                    if (i < nastroje.size() - 1)
                        System.out.print(", ");
            }
            System.out.println();
        }
        else
            System.out.println("Bedna je prazdna.");
    }
    
    public void hmotnostObojrucnychKladiv() {
        int hmotnost = 0;
        for(Nastroj n : nastroje) {
            if(n instanceof Kladivo)
                if(((Kladivo) n).isObojrucne())
                    hmotnost += ((Kladivo)n).vaha;
        }
        System.out.println("Hmotnosť obojručných kladív je " + hmotnost + " gramov");
    }
    
    /**
     * @return the maximalnaVaha
     */
    public int getMaximalnaVaha() {
        return maximalnaVaha;
    }

    /**
     * @return the vahaNaradia
     */
    public int getVahaNaradia() {
        return vahaNaradia;
    }

    /**
     * @return the nastroje
     */
    public ArrayList<Nastroj> getNastroje() {
        return nastroje;
    }
    
    
}

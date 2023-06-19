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
public class Kladivo extends Nastroj {
    
    private boolean obojrucne;
    
    public Kladivo(int vaha, String nazov, boolean obojrucne) {
        this.vaha = vaha;
        this.nazov = nazov;
        this.obojrucne = obojrucne;
    }
    
    @Override
    public String pracuj() {
        return String.format("Zatĺkam"); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the obojrucne
     */
    public boolean isObojrucne() {
        return obojrucne;
    }
    
}

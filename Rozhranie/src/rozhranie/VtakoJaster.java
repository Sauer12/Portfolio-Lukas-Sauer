/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rozhranie;

/**
 *
 * @author Luxy
 */
public class VtakoJaster extends Zviera implements JasterInterface, VtakInterface {

    public VtakoJaster(int vaha) {
        super(vaha);
    }
    
    @Override
    public void plazSa() {
        throw new UnsupportedOperationException("Plazim sa..."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void pipni() {
        throw new UnsupportedOperationException("pip pip"); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void presunSa() {
        System.out.println("Letim...");
    }
    
}

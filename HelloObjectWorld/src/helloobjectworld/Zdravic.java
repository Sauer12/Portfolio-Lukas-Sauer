/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloobjectworld;



/** Trieda reprezentuje zdravic, ktory sluzi ku zdraveniu uzivatelov */
public class Zdravic {
    /** Text pozdravu */
    public String text;
    
    /**
     * Pozdravi uzivatela textom pozdravu a jeho menom
     * @param meno Meno uzivatela
     * @return     Text s pozdravom
     */
    public String pozdrav(String meno) {
        return String.format("%s %s\n", text, meno);
    }
}

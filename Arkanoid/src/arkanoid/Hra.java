/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arkanoid;

import java.util.ArrayList;

/**
 *
 * @author Luxy
 */
public class Hra {
    private String[][] hernaPlocha;
    private Lopta lopta;
    private ArrayList<Tehlicka> tehlicky;
    
    public Hra(int loptaX, int loptaY) {
        hernaPlocha = new String[17][8];
        lopta = new Lopta(loptaX, loptaY);
        tehlicky = new ArrayList<Tehlicka>();
    }
    
    public void vykresli() {
        for(int i = 0; i < 10; i++)
            System.out.println(); 
        
        for(int i = 0; i < hernaPlocha[0].length; i++)
        {
            for(int j = 0; j < hernaPlocha.length; j++) {
                System.out.print(hernaPlocha[j][i]);
                

            }          
            System.out.println();         
        }
    }
    
    public void vytvorHernuPlochu() {
        for(int i = 0; i < hernaPlocha[0].length; i++)
        {
            for(int j = 0; j < hernaPlocha.length; j++) {
                if(i == 0 || i == hernaPlocha[0].length - 1) {
                    hernaPlocha[j][i] = "-";
                }
                else
                    hernaPlocha[j][i] = " ";
                
                if(j == 0 || j == hernaPlocha.length - 1)
                    hernaPlocha[j][i] = "|";    
                
                if((j == 0 && i == 0) || (j == hernaPlocha.length - 1 && i == hernaPlocha[0].length - 1) 
                        || (j == 0 && i == hernaPlocha[0].length - 1) || (j == hernaPlocha.length -1 && i == 0)) 
                    hernaPlocha[j][i] = "+";
            }
        }
        hernaPlocha[lopta.getX()][lopta.getY()] = "O";
        
        for(int i = 5, j = 3; i < 12; i++) {
            tehlicky.add(new Tehlicka(i, j));           
        }
        
        for(Tehlicka t : tehlicky) {
            hernaPlocha[t.getX()][t.getY()] = "x";
        }    
    }
    
    public void pohyb() {
        hernaPlocha[lopta.getX()][lopta.getY()] = " ";
        int x = lopta.getX();
        int y = lopta.getY();
        int smerX = lopta.getSmerX();
        int smerY = lopta.getSmerY();
        
        //hore -> Horna stena
        if((y + lopta.getSmerY()) < 1 ) {
            //VPRAVO dole
            if(lopta.isVpravo())
                lopta.setSmerX(1);
            //VLAVO dole
            else
                lopta.setSmerX(-1);
            
            lopta.setSmerY(1);
            lopta.setHore(false);
        }
        //vpravo -> Prava stena
        if((x + lopta.getSmerX()) >= (hernaPlocha.length - 1)) {
            //HORE
            if(lopta.isHore())
                lopta.setSmerY(-1);
            //DOLE
            else
                lopta.setSmerY(1);
            
            lopta.setSmerX(-1);
            lopta.setVpravo(false);
        }
        //dole -> Dolna stena
        if((y + lopta.getSmerY()) >= (hernaPlocha[0].length - 1)) {
            //VPRAVO hore
            if(lopta.isVpravo())
                lopta.setSmerX(1);
            //VLAVO hore
            else
                lopta.setSmerX(-1);
            
            lopta.setSmerY(-1);
            lopta.setHore(true);
        }
        //vlavo -> Lava stena
        if((x + lopta.getSmerX()) <= 1 ) {
            //HORE
            if(lopta.isHore())
                lopta.setSmerY(-1);
            //DOLE
            else
                lopta.setSmerY(1);
            lopta.setSmerX(1);
            lopta.setVpravo(true);    
        }
        
        
        lopta.setX(x + lopta.getSmerX());
        lopta.setY(y + lopta.getSmerY());       
        hernaPlocha[lopta.getX()][lopta.getY()] = "O";      
    }
    
    
}

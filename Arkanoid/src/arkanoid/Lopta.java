/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arkanoid;

/**
 *
 * @author Luxy
 */
public class Lopta {

    private int x;
    private int y;
    private int smerX = 1;
    private int smerY = -1;
    private boolean vpravo = true;
    private boolean hore = true;
        
    public Lopta(int x, int y) {
        this.x = x;
        this.y = y;
    }
    /**
     * @param smerX the smerX to set
     */
    public void setSmerX(int smerX) {
        this.smerX = smerX;
    }

    /**
     * @param smerY the smerY to set
     */
    public void setSmerY(int smerY) {
        this.smerY = smerY;
    }
   
    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @return the smerX
     */
    public int getSmerX() {
        return smerX;
    }

    /**
     * @return the smerY
     */
    public int getSmerY() {
        return smerY;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the vpravo
     */
    public boolean isVpravo() {
        return vpravo;
    }

    /**
     * @param vpravo the vpravo to set
     */
    public void setVpravo(boolean vpravo) {
        this.vpravo = vpravo;
    }

    /**
     * @return the hore
     */
    public boolean isHore() {
        return hore;
    }

    /**
     * @param hore the hore to set
     */
    public void setHore(boolean hore) {
        this.hore = hore;
    }
    
    
    
    
    
    
    
    
}

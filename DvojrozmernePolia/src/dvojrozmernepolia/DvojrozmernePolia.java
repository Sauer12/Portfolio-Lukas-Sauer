/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvojrozmernepolia;

/**
 *
 * @author Luxy
 */
public class DvojrozmernePolia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] kinosal = new int[5][5];
        kinosal[2][2] = 1;
        for (int i = 1; i < 4; i++)
        {
            kinosal[i][3] = 1;
        }
        for (int i = 0; i < 5; i++)
        {
            kinosal[i][4] = 1;
        }
        
        for (int j = 0; j < kinosal[0].length; j++)
        {
            for (int i = 0; i < kinosal.length; i++)
            {
                System.out.print(kinosal[i][j]);
            }
            System.out.println();
        }
        
    }
    
}

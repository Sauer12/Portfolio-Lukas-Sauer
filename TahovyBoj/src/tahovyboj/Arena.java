/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tahovyboj;

/**
 *
 * @author Luxy
 */
public class Arena {
    private Bojovnik bojovnik1;
    private Bojovnik bojovnik2;
    private Kocka kocka;
    
    public Arena(Bojovnik bojovnik1, Bojovnik bojovnik2, Kocka kocka) {
        this.bojovnik1 = bojovnik1;
        this.bojovnik2 = bojovnik2;
        this.kocka = kocka;
    }
    
    private void vykresli() {
        System.out.println("-------------- Aréna -------------- \n");
        System.out.println("Bojovnici: \n");
        vypisBojovnika(bojovnik1);
        System.out.println();
        vypisBojovnika(bojovnik2);
        System.out.println();
    }
    
    private void vypisSpravu(String sprava) {
        System.out.println(sprava);
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            System.err.println("Chyba, nepodarilo sa uspat vlakno");
        }
    }
    
    public void zapas() {
        Bojovnik b1 = bojovnik1;
        Bojovnik b2 = bojovnik2;
        System.out.println("Vitajte v arene!");
        System.out.printf("Dnes sa proti sebe postavia %s a %s! \n\n",bojovnik1, bojovnik2);
        
        boolean zacinaBojovnik2 = (kocka.hod() <= kocka.vratPocetStien() / 2);
        if (zacinaBojovnik2) {
            b1 = bojovnik2;
            b2 = bojovnik1;
        }
        System.out.printf("Zacinat bude bojovnik %s! \n\nZapas moze zacat...", b1);
           
        
        while (b1.nazivu() && b2.nazivu()) {
            b1.utoc(b2);
            vykresli();
            vypisSpravu(b1.vratPoslednuSpravu());
            vypisSpravu(b2.vratPoslednuSpravu());
            if( b2.nazivu()) {
                b2.utoc(b1);
                vykresli();
                vypisSpravu(b2.vratPoslednuSpravu());
                vypisSpravu(b1.vratPoslednuSpravu());
            }
            System.out.println();
        }
    }
    
    private void vypisBojovnika(Bojovnik b) {
        System.out.println(b);
        System.out.print("Zivot: ");
        System.out.println(b.grafickyZivot());
        if (b instanceof Mag) {
            System.out.print("Mana: ");
            System.out.println(((Mag)b).grafickaMana());
        }
    }
    
}

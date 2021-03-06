
package miinaharava.logiikka;

import org.junit.Test;
import static org.junit.Assert.*;

public class RuudukkoTest {
    
    public RuudukkoTest() {
        
    }

    @Test
    public void luokanLuominen1(){
        Ruudukko ruudukko = new Ruudukko(10);
        assertTrue(ruudukko.getKoko() == 10);
        assertTrue(!ruudukko.onkoMiina(0, 0));
        assertTrue(!ruudukko.onkoMerkitty(0, 0));
        assertTrue(ruudukko.getViereisetMiinat(0, 0) == 0);
    }
    
    @Test
    public void luokanLuominen2(){
        Ruudukko ruudukko = new Ruudukko(10);
        assertTrue(!ruudukko.onkoMiina(-1, -1));
        assertTrue(!ruudukko.onkoMerkitty(-1, -1));
        assertTrue(ruudukko.getViereisetMiinat(-1, -1) == -1);
    }
    
    @Test
    public void setterienTestaus(){
        Ruudukko ruudukko = new Ruudukko(10);
        
        ruudukko.asetaNakyva(5, 2);
        assertTrue(ruudukko.onkoNakyva(5, 2));
        ruudukko.asetaMiina(0, 0);
        assertTrue(ruudukko.onkoMiina(0, 0));
        ruudukko.merkitse(1, 1, true);
        assertTrue(ruudukko.onkoMerkitty(1, 1));
    }
    
    @Test
    public void virheellisetArvot(){
        Ruudukko ruudukko = new Ruudukko(10);
        //Kokeillaan mahdottomiaArvoja
        ruudukko.asetaNakyva(-1, 2);
        ruudukko.asetaNakyva(10, 10);
        ruudukko.asetaNakyva(12, 0);
    }
    
    @Test
    public void miinojenLaskenta1(){
        Ruudukko ruudukko = new Ruudukko(10);
        
        ruudukko.asetaMiina(0, 1);
        ruudukko.laskeViereisetMiinat();
        assertTrue(ruudukko.getViereisetMiinat(0, 0) == 1);
    }
    
    @Test
    public void miinojenLaskenta2(){
        Ruudukko ruudukko = new Ruudukko(10);
        
        ruudukko.asetaMiina(0, 1);
        ruudukko.asetaMiina(1, 0);
        ruudukko.laskeViereisetMiinat();
        assertTrue(ruudukko.getViereisetMiinat(0, 0) == 2);
    }
    
    @Test
    public void miinojenLaskenta3(){
        Ruudukko ruudukko = new Ruudukko(10);
        
        ruudukko.asetaMiina(1, 2);
        ruudukko.asetaMiina(1, 3);
        ruudukko.asetaMiina(1, 4);
        ruudukko.asetaMiina(2, 2);
        ruudukko.asetaMiina(2, 4);
        ruudukko.asetaMiina(3, 2);
        ruudukko.asetaMiina(3, 3);
        ruudukko.asetaMiina(3, 4);
        ruudukko.laskeViereisetMiinat();
        assertTrue(ruudukko.getViereisetMiinat(0, 0) == 0);
        assertTrue(ruudukko.getViereisetMiinat(2, 3) == 8);
        assertTrue(ruudukko.getViereisetMiinat(1, 1) == 2);
    }
    
    @Test
    public void nakyvaKetjureaktio1(){
        Ruudukko ruudukko = new Ruudukko(10);
        
        ruudukko.asetaNakyvaJaKetjureaktio(0, 0);
        assertTrue(ruudukko.onkoNakyva(0, 0));
        assertTrue(ruudukko.onkoNakyva(0, 9));
        assertTrue(ruudukko.onkoNakyva(9, 0));
        assertTrue(ruudukko.onkoNakyva(9, 9));
    }
    
    @Test
    public void viereistenMiinojenLaskenta1(){
        Ruudukko ruudukko = new Ruudukko(10);
        
        ruudukko.asetaMiina(1, 1);    
        ruudukko.laskeViereisetMiinat();
        assertTrue(ruudukko.getViereisetMiinat(0, 0) == 1);
    }
    
    public void viereistenMiinojenLaskenta2(){
        Ruudukko ruudukko = new Ruudukko(10);
        
        ruudukko.asetaMiina(1, 1);   
        ruudukko.asetaMiina(0, 1);
        ruudukko.asetaMiina(1, 0);
        ruudukko.laskeViereisetMiinat();
        assertTrue(ruudukko.getViereisetMiinat(0, 0) == 3);
    }
}

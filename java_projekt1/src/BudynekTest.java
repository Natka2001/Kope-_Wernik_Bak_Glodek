import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BudynekkTest {
    Budynek b1= new Budynek("Budynek1",EnumWydzial.WZ);
    @Test
    void setNazwa() {
        b1.setNazwa("Budynek2");
        assertEquals(b1.getNazwa(),"Budynek2");
    }

    @Test
    void tworzenie_budynku()
    {
        assertEquals(b1.getNazwa(),"Budynek1");
        assertEquals(b1.getWydzial(),EnumWydzial.WZ);
    }
    @Test
    void dodawanie_dolisty() throws WlasnyWyjatek {
        Sala s1 = new Sala("1",50,EnumTypSali.wykladowa);
        b1.DodajSale(s1);
        ArrayList<Sala> pom = new ArrayList<Sala>();
        pom.add(s1);
        assertEquals(b1.getListaSal(),pom);
    }
    @Test
    void wyjatek_sala()
    {
        Sala s2 = new Sala("2",50,EnumTypSali.wykladowa);
        assertThrows(WlasnyWyjatek.class,()->b1.UsunSale(s2));
    }
    @Test
    void wyjatek_osoba()
    {
        Pracownik p1 = new Pracownik("Maria","Moś",EnumWydzial.WILiGZ,EnumTytul.doktor);
        assertThrows(WlasnyWyjatek.class,()->b1.UsunOsobe(p1));

    }

}
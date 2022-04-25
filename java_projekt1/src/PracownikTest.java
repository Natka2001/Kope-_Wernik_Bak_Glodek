
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PracownikTest {


    Pracownik p = new Pracownik("Marian","Mol",EnumWydzial.WZ,EnumTytul.doktor);

    @Test
    void Sprawdzanie_nazwy(){
        assertEquals(p.getImie(),"Marian");
    }
    @Test
     void sprawdzenie_set()
    {
        p.setWydzial(EnumWydzial.WH);
        assertEquals(p.getWydzial(),EnumWydzial.WH);
    }


}
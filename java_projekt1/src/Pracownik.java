enum EnumTytul { magister,doktor, dogtorHabilitowany}

public class Pracownik extends Osoba
{
    // POLA
    private EnumTytul tytul;


    //getter
    public EnumTytul getTytul() {
        return tytul;
    }


    //setter
    public void setTytul(EnumTytul tytul) {
        this.tytul = tytul;
    }


    //konstruktory
    public Pracownik() {
    }

    public Pracownik(String imie, String nazwisko, EnumWydzial wydzial, EnumTytul tytul) {
        super(imie, nazwisko, wydzial);
        setTytul(tytul);
    }

    @Override
    public String toString() {
        return getTytul() + " " + super.toString();
    }
}

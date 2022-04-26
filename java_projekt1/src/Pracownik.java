enum EnumTytul { magister,doktor, dogtorHabilitowany}

/**
 * Klasa zawiera podstawowe dane pracownika, który może zarezerwować salę.
 * Klasa Pracownik dziedziczy po klasie Osoba
 */
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

    /**
     * Główny konstruktor klasy Pracownik
     * @param imie
     * @param nazwisko
     * @param wydzial
     * @param tytul
     */
    public Pracownik(String imie, String nazwisko, EnumWydzial wydzial, EnumTytul tytul) {
        super(imie, nazwisko, wydzial);
        setTytul(tytul);
    }

    /**
     * Nadpisuje metodę ToString i zwraca sformatowany string zawierający: tytuł, imie, nazwisko, wydział
     *
     * @return
     */
    @Override
    public String toString() {
        return getTytul() + " " + super.toString();
    }
}

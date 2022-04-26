import java.io.Serializable;

enum EnumWydzial {WZ, WIMIR, WINIP, WIP, WILiGZ, WH}

public abstract class Osoba implements Serializable {

    //POLA
    private String imie;
    private String nazwisko;
    private EnumWydzial wydzial;


    //settery
    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public EnumWydzial getWydzial() {
        return wydzial;
    }


    //gettery
    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setWydzial(EnumWydzial wydzial) {
        this.wydzial = wydzial;
    }


    //konstruktory
    public Osoba() {
    }

    /**
     * Główny kosntruktor klasy Osoba.
     * @param imie
     * @param nazwisko
     * @param wydzial
     */
    public Osoba(String imie, String nazwisko, EnumWydzial wydzial) {
        setImie(imie);
        setNazwisko(nazwisko);
        setWydzial(wydzial);
    }

    /**
     * Zwraca sformatowany string zawierający: imie, nazwisko, wydział
     * @return
     */
    @Override
    public String toString() {
        return getImie() +" " + getNazwisko() +
                ", wydzial: " + getWydzial() ;
    }


}

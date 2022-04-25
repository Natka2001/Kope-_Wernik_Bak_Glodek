import java.io.Serializable;

enum EnumWydzial {WZ, WIMIR, WINIP, WIP, WILiGZ, WH}

public class Osoba implements Serializable {

    //pola
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


    public Osoba(String imie, String nazwisko, EnumWydzial wydzial) {
        setImie(imie);
        setNazwisko(nazwisko);
        setWydzial(wydzial);
    }


    //tostring
    @Override
    public String toString() {
        return getImie() +" " + getNazwisko() +
                ", wydzial: " + getWydzial() ;
    }


}

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;



/**
 * Klasa zawiera podstawowe dane o budynku, liście sal oraz pracowników
 */
public class Budynek implements Serializable{
    //POLA
    private String nazwa;
    private EnumWydzial wydzial;
    private ArrayList<Sala> listaSal;
    private ArrayList<Pracownik> listaPracownikow;

    //gettery
    public String getNazwa() {
        return nazwa;
    }

    public EnumWydzial getWydzial() {
        return wydzial;
    }

    public ArrayList<Sala> getListaSal() {
        return listaSal;
    }

    public ArrayList<Pracownik> getListaPracownikow() {
        return listaPracownikow;
    }


    //settery
    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void setWydzial(EnumWydzial wydzial) {
        this.wydzial = wydzial;
    }

    public void setListaSal(ArrayList<Sala> listaSal) {
        this.listaSal = listaSal;
    }

    public void setListaOsob(ArrayList<Pracownik> listaPracownikow) {
        this.listaPracownikow = listaPracownikow;
    }


    //konstruktory
    /**
     * Pusty konstruktor inicjalizujący listę sal i listę pracowników
     */
    public Budynek() {
        listaSal = new ArrayList<Sala>();
        listaPracownikow = new ArrayList<Pracownik>();
    }

    /**
     * Główny konstruktor klasy Budynek
     * @param nazwa
     * @param wydzial
     */
    public Budynek(String nazwa, EnumWydzial wydzial) {
        listaSal = new ArrayList<Sala>();
        listaPracownikow = new ArrayList<Pracownik>();
        setNazwa(nazwa);
        setWydzial(wydzial);
    }


    //funkcje
    /**
     * Metoda dodaje salę
     * @param s
     */
    public void DodajSale(Sala s){
        listaSal.add(s);
    }


    /**
     * Metoda usuwa sale jeżeli już istnieje
     * @param s
     * @throws WlasnyWyjatek
     */
    public void UsunSale(Sala s) throws WlasnyWyjatek {
        if(listaSal.contains(s))
        {listaSal.remove(s);}
        else
        {
            throw new WlasnyWyjatek();
        }
    }

    /**
     * Metoda dodaje osobę do listy uprawnionych osób do rezerwacji sali
     * @param p
     */
    public void DodajOsobe(Pracownik p){
            listaPracownikow.add(p);
    }

    /**
     * Metoda usuwa osobe jeżeli już istnieje
     * @param o
     * @throws WlasnyWyjatek
     */
    public void UsunOsobe(Osoba o) throws WlasnyWyjatek {
        if(listaPracownikow.contains(o)) {
            listaPracownikow.remove(o);
        }
        else
        {
            throw new WlasnyWyjatek();
        }
    }

    /**
     * Metoda sortująca sale według dostępności miejsc w sali
     */
    public void SortujPoIlosci(){
        listaSal.sort(Sala::compareTo);
    }

    /**
     *Metoda soruje sale po numerze
     */
    public void SortujPoNumerze(){
        listaSal.sort(new Sala.SalaKomparator());
    }


    /**
     * Zwrócenie listy sal w budynku
     * @return
     */
    @Override
    public String toString() {
        return getNazwa() +
                ", wydzial: " + getWydzial() +
                ", listaSal: " + getListaSal();
    }


    /**
     * Zapis obiektu do pliku
     * @param nazwa
     * @throws IOException
     */
    public void zapisz(String nazwa) throws IOException {
        FileOutputStream fout = new FileOutputStream(nazwa);
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(this);
    }

    /**
     * Odczyt z pliku
     * @param nazwa
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Budynek odczytaj(String nazwa) throws IOException, ClassNotFoundException {
        FileInputStream fin = new FileInputStream(nazwa);
        ObjectInputStream ois = new ObjectInputStream(fin);
        return (Budynek)ois.readObject();
    }
}

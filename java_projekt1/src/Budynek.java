import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
    public Budynek() {
        listaSal = new ArrayList<Sala>();
        listaPracownikow = new ArrayList<Pracownik>();
    }

    public Budynek(String nazwa, EnumWydzial wydzial) {
        listaSal = new ArrayList<Sala>();
        listaPracownikow = new ArrayList<Pracownik>();
        setNazwa(nazwa);
        setWydzial(wydzial);
    }


    //funkcje
    public void DodajSale(Sala s){
        listaSal.add(s);
    }

    public void UsunSale(Sala s) throws WlasnyWyjatek {
        if(listaSal.contains(s))
        {listaSal.remove(s);}

        else
        {
            throw new WlasnyWyjatek();
        }


    }
    public void DodajOsobe(Pracownik p){
        listaPracownikow.add(p);
    }

    public void UsunOsobe(Osoba o) throws WlasnyWyjatek {
        if(listaPracownikow.contains(o)) {
            listaPracownikow.remove(o);
        }
        else
        {
            throw new WlasnyWyjatek();
        }
    }

    public void SortujPoIlosci(){
        listaSal.sort(Sala::compareTo);
    }

    public void SortujPoNumerze(){
        listaSal.sort(new Sala.SalaKomparator());
    }


    //to string
    @Override
    public String toString() {
        return getNazwa() +
                ", wydzial: " + getWydzial() +
                ", listaSal: " + getListaSal();
    }


    //zapis oi odczyt
    public void zapisz(String nazwa) throws IOException {
        FileOutputStream fout = new FileOutputStream(nazwa);
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(this);
    }
    public static Budynek odczytaj(String nazwa) throws IOException, ClassNotFoundException {
        FileInputStream fin = new FileInputStream(nazwa);
        ObjectInputStream ois = new ObjectInputStream(fin);
        return (Budynek)ois.readObject();
    }
}

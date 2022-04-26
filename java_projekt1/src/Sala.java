import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

enum EnumTypSali { wykladowa,
    labolatoryjnaChemiczna,
    labolatoryjnaFizyczna, komputerowa, cwiczeniowa }

/**
 *  Klasa zawiera podatwowe informacje o salach oraz dodaje rezerwacje
 */
public class Sala implements Comparable<Sala>, Serializable, IRezerwacja{

    //Pola
    private String numer;
    private int iloscMiejsc;
    private EnumTypSali typSali;
    ArrayList<Rezerwacja> listaRezerwacji;


    //setter
    public void setNumer(String numer) {
        this.numer = numer;
    }

    public void setIloscMiejsc(int iloscMiejsc) {
        this.iloscMiejsc = iloscMiejsc;
    }

    public void setTypSali(EnumTypSali typSali) {
        this.typSali = typSali;
    }

    public void setListaRezerwacji(ArrayList<Rezerwacja> listaRezerwacji) {
        this.listaRezerwacji = listaRezerwacji;
    }

    //getter
    public String getNumer() {
        return numer;
    }

    public int getIloscMiejsc() {
        return iloscMiejsc;
    }

    public EnumTypSali getTypSali() {
        return typSali;
    }

    public ArrayList<Rezerwacja> getListaRezerwacji() {
        return listaRezerwacji;
    }


    //konstruktory
    public Sala() {
        this.listaRezerwacji = new ArrayList<Rezerwacja>();
    }

    /**
     * Główny konstruktor klasy Sala.
     * @param numer
     * @param iloscMiejsc
     * @param typSali
     */
    public Sala(String numer, int iloscMiejsc, EnumTypSali typSali) {
        this.numer = numer;
        this.iloscMiejsc = iloscMiejsc;
        this.typSali = typSali;
        this.listaRezerwacji = new ArrayList<Rezerwacja>();
    }

    /**
     * Sprawdzenie czy istnieje już rezerwacja o takiej dacie.
     * @param r
     * @return
     */
    public boolean CheckBooking(Rezerwacja r)
    {
        for(var item : listaRezerwacji)
        {
            if (item.getDay_start().getTime() == r.getDay_start().getTime())
            {
                if ((r.getStart_time().getTime() >= item.getStart_time().getTime() && r.getStart_time().getTime() < item.getEnd_time().getTime()))
                {
                    return false;
                }
                else if (r.getEnd_time().getTime() > item.getStart_time().getTime() && r.getEnd_time().getTime() <= item.getEnd_time().getTime())
                {
                    return false;
                }
                else if (r.getStart_time().getTime() < item.getStart_time().getTime() && r.getEnd_time().getTime() > item.getEnd_time().getTime())
                {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Dodanie rezerwacji, stworzenie wyjątku gdy już istnieje rezerwacja w tym czasie
     * @param r
     * @throws WlasnyWyjatek
     */
    public  void DodajRezerwacje(Rezerwacja r) throws WlasnyWyjatek {
        if(CheckBooking(r)){
            listaRezerwacji.add(r);
        }
        else{
            System.out.println("Wybrana rezerwacja już istnieje");
        }
    }

    public void UsunRezerwacje(Rezerwacja r){
        listaRezerwacji.remove(r);
    }

    /**
     * Zwraca sformatowany string zawierający: numer, ilość miejsc, typ sali.
     * @return
     */
    @Override
    public String toString() {
        return "sala " + getTypSali() + ", numer sali: "+ getNumer() +
                ", iloscMiejsc: " + getIloscMiejsc();
    }


    //komparator
    @Override
    public int compareTo(Sala s) {
        return Integer.compare(s.getIloscMiejsc(),this.getIloscMiejsc());
    }

    public static final class SalaKomparator implements Comparator<Sala> {
        @Override
        public int compare(Sala s1, Sala s2) {
            return s1.getNumer().compareTo(s2.getNumer());       }
    }
}

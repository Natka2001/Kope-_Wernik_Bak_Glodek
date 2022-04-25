import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

enum EnumTypSali { wykladowa,
    labolatoryjnaChemiczna,
    labolatoryjnaFizyczna, komputerowa, cwiczeniowa }

public class Sala implements Comparable<Sala>, Serializable {
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
    }

    public Sala(String numer, int iloscMiejsc, EnumTypSali typSali) {
        this.numer = numer;
        this.iloscMiejsc = iloscMiejsc;
        this.typSali = typSali;
        this.listaRezerwacji = new ArrayList<Rezerwacja>();
    }

    public boolean SprawdzRezerwacje(Rezerwacja r){
        boolean c = false;
        for (Rezerwacja rez: listaRezerwacji) {
            if (rez.getDat().equals(r.getDat())) {
                return true;
            } else {
                return false;
            }
        }
        return c;
    }

    void dodajRezerwacje(Rezerwacja r) throws WlasnyWyjatek {
        if(SprawdzRezerwacje(r)){
            throw new WlasnyWyjatek();
        }
        else{
            listaRezerwacji.add(r);
        }
    }

    void usunRezerwacje(Rezerwacja r){
        listaRezerwacji.remove(r);
    }

    //tostring
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

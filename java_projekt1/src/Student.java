/**
 * Klasa zawiera podstawowe informacje o studencie
 */
public class Student extends Osoba{
    //POLA
    private String numerIndeksu;


    //setter
    public void setNumerIndeksu(String numerIndeksu) {
        this.numerIndeksu = numerIndeksu;
    }


    //getter
    public String getNumerIndeksu() {
        return numerIndeksu;
    }


    //konstruktory
    public Student() {

    }

    /**
     * Główny konstruktor klasy Student
     * @param imie
     * @param nazwisko
     * @param wydzial
     * @param numerIndeksu
     */
    public Student(String imie, String nazwisko, EnumWydzial wydzial, String numerIndeksu) {
        super(imie, nazwisko, wydzial);
        setNumerIndeksu(numerIndeksu);
    }

    /**
     * Nadpisuje metodę ToString i zwraca sformatowany string zawierający dodatkowo numer indeksu
     * @return
     */
    @Override
    public String toString() {
        return super.toString() + ", nr. indeksu: " + getNumerIndeksu();
    }
}

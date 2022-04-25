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

    public Student(String imie, String nazwisko, EnumWydzial wydzial, String numerIndeksu) {
        super(imie, nazwisko, wydzial);
        setNumerIndeksu(numerIndeksu);
    }


    //tostring
    @Override
    public String toString() {
        return super.toString() + ", nr. indeksu: " + getNumerIndeksu();
    }
}

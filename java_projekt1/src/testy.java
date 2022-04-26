import java.io.IOException;
import java.text.ParseException;

public class testy {
    public static void main(String[] args) throws WlasnyWyjatek, ParseException {

        Pracownik p1 = new Pracownik("Natalia", "Glodek", EnumWydzial.WH, EnumTytul.magister );
        Pracownik p2 = new Pracownik("Dawid", "Kopec", EnumWydzial.WZ, EnumTytul.dogtorHabilitowany );
        Pracownik p3 = new Pracownik("Ewelina", "Wernik", EnumWydzial.WZ, EnumTytul.dogtorHabilitowany );

        Student s1 = new Student("Faustyna", "Bak", EnumWydzial.WH, "123456");
        Student s2 = new Student("Ewelina", "Wernik", EnumWydzial.WIP, "123457");

        //System.out.println(p1 + "\n" + p2 + "\n" + s1 + "\n" + s2);

        Sala sala1 = new Sala("3.1", 30, EnumTypSali.wykladowa);
        Sala sala2 = new Sala("259", 150, EnumTypSali.labolatoryjnaChemiczna);
        Sala sala3 = new Sala("114", 300, EnumTypSali.labolatoryjnaFizyczna);
        Sala sala4 = new Sala("1.3", 50, EnumTypSali.cwiczeniowa);

        //System.out.println(sala1);

        Budynek b = new Budynek("Wydział Zarządzania", EnumWydzial.WZ);

        b.DodajSale(sala1);
        b.DodajSale(sala2);
        b.DodajSale(sala3);
        b.DodajSale(sala4);

        //System.out.println(b);

        //System.out.println(b);
        Rezerwacja r1 = new Rezerwacja(p1,"12.04.2022 22:00", 100);
        Rezerwacja r2 = new Rezerwacja(p2,"15.04.2022 6:30", 60);
        Rezerwacja r3 = new Rezerwacja(p3,"15.04.2022 23:30", 60);
        // Rezerwacja r4 = new Rezerwacja(s1,"15.04.2022 1:30", 60);

        System.out.println(r1);

        sala1.DodajRezerwacje(r1);
        sala1.DodajRezerwacje(r2);
        sala1.DodajRezerwacje(r3);
        // sala1.AddBooking(r4);

        b.DodajOsobe(p1);
        b.DodajOsobe(p2);

        try {
            b.zapisz("budynek.bin");
        } catch (IOException e) {
            e.printStackTrace();
        }


        Budynek b2 = null;
        try {
            b2 = Budynek.odczytaj("budynek.bin");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //System.out.println(b2);

        System.out.println(b);

        b.SortujPoIlosci();

        System.out.println("\npo");
        System.out.println(b);


    }

}

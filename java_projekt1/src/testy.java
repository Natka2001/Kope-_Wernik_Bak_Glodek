import java.io.IOException;

public class testy {
    public static void main(String[] args) throws WlasnyWyjatek {

        Pracownik p1 = new Pracownik("Natalia", "Glodek", EnumWydzial.WH, EnumTytul.magister );
        Pracownik p2 = new Pracownik("Dawid", "Kopec", EnumWydzial.WZ, EnumTytul.dogtorHabilitowany );

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

        Rezerwacja r2 = new Rezerwacja("30.04.2022 14:00", 60, p1);
        Rezerwacja r1 = new Rezerwacja("15.04.2022 15:00", 60, p2);
        Rezerwacja r3 = new Rezerwacja("15.04.2022 15:00", 60, p2);


        sala1.dodajRezerwacje(r1);
       sala1.dodajRezerwacje(r2);
       try {
           sala1.dodajRezerwacje(r3);
       }catch(WlasnyWyjatek e){
           System.out.println(e);
       }

        sala3.dodajRezerwacje(r3);
       //System.out.println(sala1);
        //System.out.println(sala3);

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

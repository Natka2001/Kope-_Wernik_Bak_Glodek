import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Rezerwacja implements Serializable {
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    private int duration;
    private SimpleDateFormat form = new SimpleDateFormat("dd.MM.yyyy HH:mm");

    public void setDate(String date) {
        try {
            this.date = form.parse(date);
        } catch (Exception e) {
            System.out.println();
        }
    }

    private Date date;
    private Date end;

    public Pracownik getP() {
        return p;
    }

    public void setP(Pracownik p) {
        this.p = p;
    }

    Pracownik p;


    public Rezerwacja(){}

    public Rezerwacja(String dat, int duration, Pracownik p) {
        // initialise instance variables
        date = new Date();
        end = new Date();
        try {
            date = form.parse(dat);
        } catch (Exception e) {
            System.out.println();
        }
        this.duration = duration;
        endSlotCal(date);

        this.p = p;
    }

    private void endSlotCal(Date date) {
        long min = date.getTime();
        end.setTime(min + (duration * 60 * 1000));
        //System.out.println(end);
    }

    public Date getDat() {
        return date;
    }

    public Date getEnd() {
        return end;
    }


    /**
     * @return it returns time and duration of slot.
     */
    public String toString() {
        String str = "";
        str = str + form.format(date) + " - " + duration;
        return str;
    }
}

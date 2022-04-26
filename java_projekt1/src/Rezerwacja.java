import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Rezerwacja implements Serializable {
    public Pracownik getP() {
        return p;
    }

    public void setP(Pracownik p) {
        this.p = p;
    }

    Pracownik p;

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    private int duration;
    private Date date;
    private Date end;
    private Date day_start;
    private Date start_time;
    private Date end_time;
    private String string_end_time;
    private String string_start_time;
    private String string_day_start;
    private SimpleDateFormat time = new SimpleDateFormat("HH:mm");
    private SimpleDateFormat form = new SimpleDateFormat("dd.MM.yyyy HH:mm");
    private SimpleDateFormat day = new SimpleDateFormat("dd.MM.yyyy");

    public String getString_end_time() {
        return string_end_time;
    }

    public void setString_end_time(String string_end_time) {
        this.string_end_time = string_end_time;
    }

    public Date getDay_start() {
        return day_start;
    }

    public void setDay_start(Date day_start) {
        this.day_start = day_start;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public Date getEnd() {
        return end;
    }

    public Rezerwacja(Pracownik p, String dat, int duration) throws ParseException {
        this.p =p;
        date = new Date();
        end = new Date();
        start_time = new Date();
        string_start_time = dat;
        try {
            date = form.parse(dat);
            setDate(date);
        } catch (Exception e) {
            System.out.println();
        }
        this.duration = duration;
        endSlotCal(date);

        string_start_time=toTimeString(date);
        string_end_time=toTimeString(end);
        string_day_start=toDateString(date);
        start_time=time.parse(string_start_time);
        end_time=time.parse(string_end_time);
        day_start=day.parse(string_day_start);
    }
    public String toTimeString(Date date) {
        if (date == null) {
            return null;
        }
        String dateStr = time.format(date);
        return dateStr;
    }
    public String toDateString(Date date){
        if (date == null) {
            return null;
        }
        String dateStr = day.format(date);
        return dateStr;
    }

    private void endSlotCal(Date date) {
        long min = date.getTime();
        end.setTime(min + (duration * 60 * 1000));
    }

    public String toString() {
        String str = "";
        str = "[" + form.format(date) + " - " + form.format(end) + "] Czas trwania: " + duration + " minut.";
        return str;
    }
}

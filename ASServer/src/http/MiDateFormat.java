package http;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Adolfo
 */
public class MiDateFormat {

    private String dayOfWeek;
    private int dayNumber;
    private String month;
    private int year;
    private String hour;
    private String tipe;

    public MiDateFormat(String dayOfWeek, int dayNumber, String month, int year, String hour, String tipe) {
        this.dayOfWeek = dayOfWeek;
        this.dayNumber = dayNumber;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.tipe = tipe;
    }

    public MiDateFormat() {   }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public String getDateFormat() {
        //Date: Thu, 04 Dec 2014 03:30:49 GMT
        Calendar cal = Calendar.getInstance();
        String dayofWeek = "";
        String mes = "";
        int month = cal.get(Calendar.MONTH);
        if (cal.get(Calendar.DAY_OF_WEEK) == 1) {
            dayofWeek = "Sun";
        }
        if (cal.get(Calendar.DAY_OF_WEEK) == 2) {
            dayofWeek = "Mon";
        }
        if (cal.get(Calendar.DAY_OF_WEEK) == 3) {
            dayofWeek = "Tue";
        }
        if (cal.get(Calendar.DAY_OF_WEEK) == 4) {
            dayofWeek = "Wed";
        }
        if (cal.get(Calendar.DAY_OF_WEEK) == 5) {
            dayofWeek = "Thu";
        }
        if (cal.get(Calendar.DAY_OF_WEEK) == 6) {
            dayofWeek = "Fri";
        }
        if (cal.get(Calendar.DAY_OF_WEEK) == 7) {
            dayofWeek = "Sat";
        }

        if (month == cal.JANUARY) {
            mes = "Jan";
        }
        if (month == cal.FEBRUARY) {
            mes = "Feb";
        }
        if (month == cal.MARCH) {
            mes = "Mar";
        }
        if (month == cal.APRIL) {
            mes = "Apr";
        }
        if (month == cal.MAY) {
            mes = "May";
        }
        if (month == cal.JUNE) {
            mes = "Jun";
        }
        if (month == cal.JULY) {
            mes = "Jul";
        }
        if (month == cal.AUGUST) {
            mes = "Aug";
        }
        if (month == cal.SEPTEMBER) {
            mes = "Sepr";
        }
        if (month == cal.OCTOBER) {
            mes = "Oct";
        }
        if (month == cal.NOVEMBER) {
            mes = "Nov";
        }
        if (month == cal.DECEMBER) {
            mes = "Dec";
        }
        String dia = "" + cal.get(Calendar.DATE);
        if (cal.get(Calendar.DATE) < 10) {
            dia = "0" + cal.get(Calendar.DATE);
        }

        Calendar gregoCalen = new GregorianCalendar();
        String hora = gregoCalen.get(Calendar.HOUR_OF_DAY) + "";
        String minuto = gregoCalen.get(Calendar.MINUTE) + "";
        String segundos = gregoCalen.get(Calendar.SECOND) + "";

        //Date: Thu, 04 Dec 2014 03:30:49 GMT
        return dayofWeek + ", " + dia + " " + mes + " " + cal.get(Calendar.YEAR)
                +" "+hora+":"+minuto+":"+segundos+" GMT";
    }

}

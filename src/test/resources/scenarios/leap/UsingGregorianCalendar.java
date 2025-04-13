import java.util.Calendar;
import java.util.GregorianCalendar;

class Leap {
    boolean isLeapYear(int year) {
        var calendar = new GregorianCalendar(Calendar.ALL_STYLES);
        return calendar.isLeapYear(year);
    }
}

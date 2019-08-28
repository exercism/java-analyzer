import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Calendar;

class Gigasecond {

    private Calendar dateTime;

    private final static long gigasecondInMillis = 1000000000L * 1000L;

    Gigasecond(LocalDate moment) {
        dateTime = toCalendarDate(moment);
    }

    Gigasecond(LocalDateTime moment) {
        dateTime = toCalendarDateTime(moment);
    }

    LocalDateTime getDateTime() {
        Calendar cal = getGigasecond(dateTime);
        return toLocalDateTime(cal);
    }

    private Calendar toCalendarDate(LocalDate moment) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, moment.getYear());
        cal.set(Calendar.MONTH, moment.getMonth().ordinal());
        cal.set(Calendar.DAY_OF_MONTH, moment.getDayOfMonth());
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal;
    }

    private Calendar toCalendarDateTime(LocalDateTime moment) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, moment.getYear());
        cal.set(Calendar.MONTH, moment.getMonth().ordinal());
        cal.set(Calendar.DAY_OF_MONTH, moment.getDayOfMonth());
        cal.set(Calendar.HOUR_OF_DAY, moment.getHour());
        cal.set(Calendar.MINUTE, moment.getMinute());
        cal.set(Calendar.SECOND, moment.getSecond());
        cal.set(Calendar.MILLISECOND, 0);
        return cal;
    }

    private LocalDateTime toLocalDateTime(Calendar cal) {
        return LocalDateTime.of(cal.get(Calendar.YEAR),
                Month.values()[cal.get(Calendar.MONTH)],
                cal.get(Calendar.DAY_OF_MONTH),
                cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE),
                cal.get(Calendar.SECOND));
    }

    private Calendar getGigasecond(Calendar dateTime) {
        Long timestamp = dateTime.getTimeInMillis() + gigasecondInMillis;
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(timestamp);
        return cal;
    }
}

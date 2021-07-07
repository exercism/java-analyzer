import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

class Gigasecond {
    static Long GIGA = (long) Math.pow(10d, 9d);
    private LocalDateTime date;

    Gigasecond(LocalDate moment) {
        this.date = moment.atStartOfDay();
    }

    Gigasecond(LocalDateTime moment) {
        this.date = moment;
    }

    LocalDateTime getDateTime() {
        return date.plusSeconds(GIGA);
    }

}

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

class Gigasecond {

    private LocalDateTime dateTime;

    Gigasecond(LocalDate moment) {
        dateTime = moment.atTime(0, 0, 0);
    }

    Gigasecond(LocalDateTime moment) {
        dateTime = moment;
    }

    LocalDateTime getDateTime() {
        long addSeconds = (long)Math.pow(10, 9);
        return dateTime.plus(addSeconds, ChronoUnit.SECONDS);
    }

}




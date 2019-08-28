import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

class Gigasecond {

    private LocalDateTime dateTime;

    Gigasecond(LocalDate moment) {
        dateTime = moment.atTime(0,0,0);
    }

    Gigasecond(LocalDateTime moment) {
        dateTime = moment;
    }

    LocalDateTime getDateTime() {
        long gigaSecond = 1_000_000_000;
        return dateTime.plus(gigaSecond, ChronoUnit.SECONDS);
    }

}

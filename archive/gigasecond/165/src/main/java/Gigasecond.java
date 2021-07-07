import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    LocalDateTime gigadate;
    Gigasecond(LocalDate moment) {
        gigadate=moment.atStartOfDay();
    }

    Gigasecond(LocalDateTime moment) {
        gigadate=moment;
    }

    LocalDateTime getDateTime() {
        return gigadate.plus(1000000000, java.time.temporal.ChronoUnit.SECONDS);
    }

}

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

class Gigasecond {

    private static final long GIGASECOND_IN_MILLIS = 1_000_000_000_000L;

    private LocalDateTime dateTime;

    Gigasecond(LocalDate moment) {
        this.dateTime = LocalDateTime.of(moment, LocalTime.of(0, 0));
    }

    Gigasecond(LocalDateTime moment) {
        this.dateTime = moment;
    }

    LocalDateTime getDateTime() {
        return dateTime.plus(GIGASECOND_IN_MILLIS, ChronoUnit.MILLIS);
    }
}

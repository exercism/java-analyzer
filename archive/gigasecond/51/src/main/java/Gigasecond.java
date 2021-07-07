import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

class Gigasecond {
    private static LocalDateTime momentTime;
    private final static LocalTime noon = LocalTime.of(0, 0);

    Gigasecond(final LocalDate moment) {
        this.momentTime = LocalDateTime.of(moment, noon);
    }

    Gigasecond(final LocalDateTime moment) {
        this.momentTime = moment;
    }

    LocalDateTime getDateTime() {
        return momentTime.plus(1_000_000_000, ChronoUnit.SECONDS);
    }
}

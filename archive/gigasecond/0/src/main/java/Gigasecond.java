import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

class Gigasecond {
    private static final long OFFSET = 1_000_000_000;
    private LocalDateTime after;

    Gigasecond(LocalDate moment) {
        this(LocalDateTime.of(moment, LocalTime.MIDNIGHT));
    }

    Gigasecond(LocalDateTime moment) {
        after = moment.plus(OFFSET, ChronoUnit.SECONDS);
    }

    LocalDateTime getDateTime() {
        return after;
    }

}

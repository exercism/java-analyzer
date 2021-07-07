import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

class Gigasecond {

    private static final int GIGA = 1_000_000_000;
    private LocalDateTime added;

    Gigasecond(LocalDate moment) {
        added = moment.atStartOfDay().plus(GIGA, ChronoUnit.SECONDS);
    }

    Gigasecond(LocalDateTime moment) {
        added = moment.plus(GIGA, ChronoUnit.SECONDS);
    }

    LocalDateTime getDateTime() {
        return added;
    }

}

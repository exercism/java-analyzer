import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    private static final long BILLION = 1_000_000_000;
    private LocalDateTime dateTime;

    Gigasecond(LocalDate moment) {
        dateTime = moment.atStartOfDay().plusSeconds(BILLION);
    }

    Gigasecond(LocalDateTime moment) {
        dateTime = moment.plusSeconds(BILLION);
    }

    LocalDateTime getDateTime() {
        return dateTime;
    }
}

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private static final Duration GIGASECOND = Duration.ofSeconds((long)1e9);
    private LocalDateTime dateTime;

    Gigasecond(LocalDate moment) {
        dateTime = moment.atStartOfDay();
    }

    Gigasecond(LocalDateTime moment) {
        dateTime = moment;
    }

    LocalDateTime getDateTime() {
        return dateTime.plus(GIGASECOND);
    }

}
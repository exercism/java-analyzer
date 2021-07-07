import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

class Gigasecond {

    private static final Duration GIGASECOND = Duration.of(1_000_000_000L, ChronoUnit.SECONDS);
    private final LocalDateTime moment;

    Gigasecond(LocalDate birthDate) {
        this(birthDate.atTime(0, 0, 0));
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.moment = birthDateTime.plus(GIGASECOND);
    }

    LocalDateTime getDateTime() {
        return moment;
    }

}

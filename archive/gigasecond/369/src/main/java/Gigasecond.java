import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Duration;

class Gigasecond {
    private final Duration GIGASECOND = Duration.ofSeconds(1000000000);

    LocalDateTime dateTime;

    Gigasecond(LocalDate birthDate) {
        this.dateTime = birthDate.atStartOfDay().plus(GIGASECOND);
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.dateTime = birthDateTime.plus(GIGASECOND);
    }

    LocalDateTime getDateTime() {
        return this.dateTime;
    }

}

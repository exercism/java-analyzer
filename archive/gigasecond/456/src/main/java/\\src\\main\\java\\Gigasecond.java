import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    private final LocalDateTime date;

    Gigasecond(LocalDate birthDate) {
        date = birthDate.atStartOfDay();
    }

    Gigasecond(LocalDateTime birthDateTime) {
        date = birthDateTime;
    }

    LocalDateTime getDateTime() {
        long gigasec = 1000000000;
        return date.plus(Duration.ofSeconds(gigasec));
    }

}

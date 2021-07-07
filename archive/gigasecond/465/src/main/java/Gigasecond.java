import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

class Gigasecond {

    private final LocalDateTime calculatedInstant;

    Gigasecond(LocalDate birthDate) {
        this(birthDate.atStartOfDay());
    }

    Gigasecond(LocalDateTime birthDateTime) {
        calculatedInstant = birthDateTime.plus(1_000_000_000, ChronoUnit.SECONDS);
    }

    LocalDateTime getDateTime() {
        return calculatedInstant;
    }

}

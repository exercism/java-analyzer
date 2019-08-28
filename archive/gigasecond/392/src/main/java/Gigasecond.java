import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private final LocalDateTime datetime;

    Gigasecond(LocalDateTime birthDateTime) {
        datetime = birthDateTime.plusSeconds(1_000_000_000);
    }

    Gigasecond(LocalDate birthDate) {
        this(birthDate.atStartOfDay());
    }

    LocalDateTime getDateTime() {
        return datetime;
    }

}

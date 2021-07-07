import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private final LocalDateTime birthDateTime;
    private final long gigasecond = 1_000_000_000;

    Gigasecond(LocalDate birthDate) {
        this.birthDateTime = birthDate.atStartOfDay();
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.birthDateTime = birthDateTime;
    }

    LocalDateTime getDateTime() {
        return this.birthDateTime.plusSeconds(gigasecond);
    }

}

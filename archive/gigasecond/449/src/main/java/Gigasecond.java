import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private final static long GIGA_SECOND = 1_000_000_000;

    private final LocalDateTime dateTime;

    Gigasecond(LocalDate birthDate) {
        dateTime = birthDate.atStartOfDay();
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.dateTime = birthDateTime;
    }

    LocalDateTime getDateTime() {
        return dateTime.plusSeconds(GIGA_SECOND);
    }

}

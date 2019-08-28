import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    private final LocalDateTime dateTime;

    Gigasecond(LocalDate birthDate) {
        this.dateTime = birthDate.atStartOfDay();
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.dateTime = birthDateTime;
    }

    LocalDateTime getDateTime() {
        return dateTime.plusSeconds(1_000_000_000);
        }

}

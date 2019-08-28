import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    LocalDateTime start;

    Gigasecond(LocalDate birthDate) {
        start = birthDate.atTime(0,0);
    }

    Gigasecond(LocalDateTime birthDateTime) {
        start = birthDateTime;
    }

    LocalDateTime getDateTime() {
        return start.plusSeconds(1000000000L);
    }
}

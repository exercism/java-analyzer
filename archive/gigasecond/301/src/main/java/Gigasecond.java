import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    private static final long GIGA = (long) Math.pow(10, 9);
    private LocalDateTime birthDateTime;

    Gigasecond(LocalDate birthDate) {
        this.birthDateTime = birthDate.atStartOfDay();
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.birthDateTime = birthDateTime;
    }

    LocalDateTime getDateTime() {
        return birthDateTime.plusSeconds(GIGA);
    }

}

import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private final long GIGASECOND = 1000000000L;

    private LocalDateTime birthLocalDateTime;

    Gigasecond(LocalDate birthDate) {
        this.birthLocalDateTime = birthDate.atStartOfDay();
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.birthLocalDateTime = birthDateTime;
    }

    LocalDateTime getDateTime() {
        return birthLocalDateTime.plusSeconds(GIGASECOND);
    }

}

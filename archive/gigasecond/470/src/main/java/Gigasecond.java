import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    private static final Double GIGA_SECOND = 1E9;
    private LocalDateTime birthDateTime;

    Gigasecond(LocalDateTime birthDateTime) {
        this.birthDateTime = birthDateTime;
    }

    Gigasecond(LocalDate birthDate) {
        this(birthDate.atStartOfDay());
    }

    LocalDateTime getDateTime() {
        return birthDateTime.plusSeconds(GIGA_SECOND.intValue());
    }
}

import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    private static final int GIGA_SECOND = 1000000000;
    private LocalDateTime birthDateTime;

    Gigasecond(LocalDate birthDateTime) {
        this(birthDateTime.atStartOfDay());
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.birthDateTime = birthDateTime.plusSeconds(GIGA_SECOND);
    }

    LocalDateTime getDateTime() {
        return this.birthDateTime;
    }

}

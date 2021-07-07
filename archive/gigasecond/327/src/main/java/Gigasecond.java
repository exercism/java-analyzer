import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    private final long life = 1_000_000_000;
    LocalDateTime ldt;

    Gigasecond(LocalDate birthDate) {
        this.ldt = birthDate.atStartOfDay().plusSeconds(life);
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.ldt = birthDateTime.plusSeconds(life);
    }

    LocalDateTime getDateTime() {
        return this.ldt;
    }

}

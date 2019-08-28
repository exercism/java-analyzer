import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalUnit;


class Gigasecond {
    private LocalDateTime birthDate;

    Gigasecond(LocalDate birthDate) {
        this.birthDate = birthDate.atStartOfDay();
    }

    Gigasecond(LocalDateTime birthDateTime) {
        birthDate = birthDateTime;
    }

    LocalDateTime getDateTime() {
        return birthDate.plusSeconds(1000000000);
    }

}

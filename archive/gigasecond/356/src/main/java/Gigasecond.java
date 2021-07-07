import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private static int GIGASECONDS = 1_000_000_000;
    private LocalDateTime birthDate;

    Gigasecond(LocalDate birthDate) {
        this.birthDate = birthDate.atStartOfDay();
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.birthDate = birthDateTime;
    }

    LocalDateTime getDateTime() {
        return birthDate.plusSeconds(GIGASECONDS);
    }

}

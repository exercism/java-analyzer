import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

class Gigasecond {
    private LocalDateTime birthDate;
    private static final long SECONDS = 1000000000;

    Gigasecond(LocalDate birthDate) {
        this.birthDate = LocalDateTime.of(birthDate, LocalTime.of(0, 0));
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.birthDate = birthDateTime;
    }

    LocalDateTime getDateTime() {
        return birthDate.plusSeconds(SECONDS);
    }

}

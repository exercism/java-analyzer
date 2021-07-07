import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

class Gigasecond {
    private LocalDateTime birthDateTime;

    Gigasecond(LocalDate birthDate) {
        birthDateTime = LocalDateTime.of(birthDate, LocalTime.MIN);
    }
    Gigasecond(LocalDateTime birthDateTime) {
        this.birthDateTime = birthDateTime;
    }

    LocalDateTime getDateTime() {
        final long GIGASECOND = 1000000000;
        return birthDateTime.plusSeconds(GIGASECOND);
    }
}

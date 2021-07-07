import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

class Gigasecond {
    private LocalDateTime birthTime;

    Gigasecond(LocalDate birthDate) {
        birthTime = LocalDateTime.of(birthDate, LocalTime.of(0, 0, 0));
    }

    Gigasecond(LocalDateTime birthDateTime) {
        birthTime = birthDateTime;
    }

    LocalDateTime getDateTime() {
        return birthTime.plusSeconds(1_000_000_000L);
    }

}

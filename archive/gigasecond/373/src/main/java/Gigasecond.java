import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAmount;

class Gigasecond {

    private static final TemporalAmount GIGASECOND = Duration.ofSeconds(1000000000);
    private LocalDateTime birthDateTime;

    Gigasecond(LocalDate birthDate) {
        this.birthDateTime = LocalDateTime.of(birthDate, LocalTime.MIDNIGHT);
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.birthDateTime = birthDateTime;
    }

    LocalDateTime getDateTime() {
        return birthDateTime.plus(GIGASECOND);
    }

}

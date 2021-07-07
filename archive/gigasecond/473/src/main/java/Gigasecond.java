import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAmount;

class Gigasecond {

    private static final TemporalAmount GIGASECOND = Duration.ofSeconds(1000000000);

    private LocalDateTime birthTemporal;

    Gigasecond(LocalDate birthDate) {
        this(LocalDateTime.of(birthDate, LocalTime.MIN));
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.birthTemporal = birthDateTime;
    }

    LocalDateTime getDateTime() {
        return this.birthTemporal.plus(GIGASECOND);
    }

}

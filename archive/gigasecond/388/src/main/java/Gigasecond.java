import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

class Gigasecond {
    private static final int ONE_GIGASECOND = 1000000000;
    LocalDateTime dateTime;

    Gigasecond(LocalDate birthDate) {
        this(LocalDateTime.of(birthDate, LocalTime.MIN));
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.dateTime = addGigasecond(birthDateTime);
    }

    private LocalDateTime addGigasecond(LocalDateTime birthDateTime) {
        return birthDateTime.plus(Duration.ofSeconds(ONE_GIGASECOND));
    }

    LocalDateTime getDateTime() {
        return this.dateTime;
    }

}

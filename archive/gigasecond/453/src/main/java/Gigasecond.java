import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

class Gigasecond {
    private LocalDateTime birthDateTime;
    private final Long gigaSecond = 1000000000L;

    Gigasecond(LocalDate birthDate) {
        this.birthDateTime  = LocalDateTime.of(birthDate, LocalTime.MIDNIGHT);
    }

    Gigasecond(LocalDateTime birthDateTime) {
    this.birthDateTime = birthDateTime;
    }

    LocalDateTime getDateTime() {
        return birthDateTime.plusSeconds(gigaSecond);
    }

}

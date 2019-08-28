import java.time.*;
import java.time.temporal.ChronoUnit;

class Gigasecond {
    private final long GIGASECOND = 1000000000L;
    private final LocalDateTime gigasecondDate;

    Gigasecond(LocalDate birthDate) {
        gigasecondDate = birthDate.atStartOfDay().plus(GIGASECOND, ChronoUnit.SECONDS);
    }

    Gigasecond(LocalDateTime birthDateTime) {
        gigasecondDate = birthDateTime.plus(GIGASECOND, ChronoUnit.SECONDS);
    }

    LocalDateTime getDateTime() {
        return gigasecondDate;
    }

}

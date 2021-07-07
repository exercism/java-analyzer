import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;

class Gigasecond {
    private static final int GSEC = 1000000000;

    private final LocalDateTime dateTime;

    Gigasecond(LocalDate birthDate) {
        dateTime = birthDate.atStartOfDay();
    }

    Gigasecond(LocalDateTime birthDateTime) {
        dateTime = birthDateTime;
    }

    LocalDateTime getDateTime() {
        return dateTime.plus(GSEC, ChronoUnit.SECONDS);
    }

}

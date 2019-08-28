import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

class Gigasecond {
    private final int GIGA = 1000000000;
    private LocalDateTime gigasecond;

    Gigasecond(LocalDate moment) {
        this(moment.atStartOfDay());
    }

    Gigasecond(LocalDateTime moment) {
        this.gigasecond = moment.plus(GIGA, ChronoUnit.SECONDS);
    }

    LocalDateTime getDateTime() {
        return this.gigasecond;
    }
}

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

class Gigasecond {

    private LocalDateTime time;

    Gigasecond(LocalDate moment) {
        this.time = moment.atStartOfDay().plus(1_000_000_000L, ChronoUnit.SECONDS);
    }

    Gigasecond(LocalDateTime moment) {
        this.time = moment.plus(1_000_000_000L, ChronoUnit.SECONDS);
    }

    LocalDateTime getDateTime() {
        return this.time;
    }

}

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Duration;

class Gigasecond {

    private final Duration GIGASECOND = Duration.ofSeconds(1_000_000_000L);
    private LocalDateTime momentPlusGigasecond;

    Gigasecond(LocalDate moment) {
        this(moment.atStartOfDay());
    }

    Gigasecond(LocalDateTime moment) {
        this.momentPlusGigasecond = moment.plus(GIGASECOND);
    }

    LocalDateTime getDateTime() {
        return this.momentPlusGigasecond;
    }

}

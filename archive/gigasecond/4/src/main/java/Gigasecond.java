import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    private static final int GIGA_SECOND = 1000_000_000;
    private final LocalDateTime momentAfter;

    Gigasecond(LocalDate moment) {
        this(moment.atTime(0, 0));
    }

    Gigasecond(LocalDateTime moment) {
        this.momentAfter = moment.plusSeconds(GIGA_SECOND);
    }

    LocalDateTime getDateTime() {
        return momentAfter;
    }

}

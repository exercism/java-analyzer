import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

class Gigasecond {

    private static final long OFFSET = 1000000000L;
    private static final TemporalUnit OFFSET_UNIT = ChronoUnit.SECONDS;
    private final LocalDateTime offsetTime;

    Gigasecond(LocalDate moment) {
        this(moment.atStartOfDay());
    }

    Gigasecond(LocalDateTime moment) {
        offsetTime = moment.plus(OFFSET, OFFSET_UNIT);
    }

    LocalDateTime getDateTime() {
        return offsetTime;
    }

}

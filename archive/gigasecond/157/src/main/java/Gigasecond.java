import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

class Gigasecond {

    private static final int ONE_BILLION_SECONDS = 1_000_000_000;

    private LocalDateTime newMoment;

    Gigasecond(final LocalDate moment) {
        this.newMoment = moment.atStartOfDay().plus(ONE_BILLION_SECONDS, ChronoUnit.SECONDS);
    }

    Gigasecond(final LocalDateTime moment) {
        this.newMoment = moment.plus(ONE_BILLION_SECONDS, ChronoUnit.SECONDS);
    }

    LocalDateTime getDateTime() {
        return this.newMoment;
    }
}

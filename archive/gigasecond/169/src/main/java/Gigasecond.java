import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

final class Gigasecond {
    final static private int GIGASECOND = (int)1e9;
    final private LocalDateTime moment;

    Gigasecond(LocalDateTime moment) {
        this.moment = moment.plus(GIGASECOND, ChronoUnit.SECONDS);
    }

    Gigasecond(LocalDate moment) {
        this(moment.atTime(0, 0));
    }

    LocalDateTime getDateTime() {
        return this.moment;
    }
}

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static java.time.temporal.ChronoUnit.SECONDS;

class Gigasecond {

    private static final int GIGASECOND = 1_000_000_000;
    private final LocalDateTime moment;

    Gigasecond(LocalDate moment) {
        this(moment.atStartOfDay());
    }

    Gigasecond(LocalDateTime moment) {
        this.moment = moment.plusSeconds(GIGASECOND);
    }

    LocalDateTime getDateTime() {
        return moment;
    }

}

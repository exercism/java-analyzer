import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static java.lang.Math.*;

class Gigasecond {
    private static final long GIGASECOND = (long) pow(10, 9);
    private final LocalDateTime startTimeMoment;

    Gigasecond(LocalDate moment) {
        final LocalTime defaultLocalTime = LocalTime.of(0,0);
        this.startTimeMoment = LocalDateTime.of(moment, defaultLocalTime);
    }

    Gigasecond(LocalDateTime moment) {
        this.startTimeMoment = moment;
    }

    LocalDateTime getDateTime() {
        return startTimeMoment.plusSeconds(GIGASECOND);
    }
}

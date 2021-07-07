import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private static final Long GIGASECOND = 1000000000L;
    private LocalDateTime timeAfter;

    Gigasecond(LocalDate moment) {
        timeAfter = moment.atStartOfDay().plusSeconds(GIGASECOND);
    }

    Gigasecond(LocalDateTime moment) {
        timeAfter = moment.plusSeconds(GIGASECOND);
    }

    LocalDateTime getDateTime() {
        return this.timeAfter;
    }
}

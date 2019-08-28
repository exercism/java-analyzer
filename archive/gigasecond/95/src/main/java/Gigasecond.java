import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;
import java.util.concurrent.TimeUnit;

class Gigasecond {

    private static final long GIGASECOND = 1_000_000_000;
    private LocalDateTime moment;

    Gigasecond(LocalDateTime moment) {
        this.moment = moment;
    }

    Gigasecond(LocalDate moment) {
        this.moment = moment.atStartOfDay();
    }


    LocalDateTime getDateTime() {
        return moment.plusSeconds(GIGASECOND);
    }

}

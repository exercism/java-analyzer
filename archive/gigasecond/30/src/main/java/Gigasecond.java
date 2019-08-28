import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.concurrent.TimeUnit;

class Gigasecond {

    private static final long GIGASECOUND = 1000000000;
    private LocalDateTime localDT;

    Gigasecond(LocalDate moment) {
        localDT = moment.atStartOfDay().plus(GIGASECOUND, ChronoUnit.SECONDS);
    }

    Gigasecond(LocalDateTime moment) {
        localDT = moment.plusSeconds(GIGASECOUND);
    }

    LocalDateTime getDateTime() {
        return this.localDT;
    }

}

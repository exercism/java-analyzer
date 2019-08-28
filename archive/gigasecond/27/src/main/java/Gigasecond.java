import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

class Gigasecond {
    public final long GIGASECOND = 1000000000;
    LocalDateTime time;

    Gigasecond(LocalDate moment) {
        time = moment.atStartOfDay().plus(GIGASECOND, ChronoUnit.SECONDS);
    }

    Gigasecond(LocalDateTime moment) {
        time = moment.plus(GIGASECOND, ChronoUnit.SECONDS);
    }

    LocalDateTime getDateTime() {
        return time;    
    }

}

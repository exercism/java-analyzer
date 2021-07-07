import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

class Gigasecond {
    private LocalDateTime dt = null;

    public Gigasecond(LocalDate moment) {
        dt = moment.atStartOfDay().plus(1000000000, ChronoUnit.SECONDS);
    }

    public Gigasecond(LocalDateTime moment) {
        dt = moment.plus(1000000000, ChronoUnit.SECONDS);
    }

    public LocalDateTime getDateTime() {
        return dt;
    }

}

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Gigasecond {
    private static final int GIGASECOND = 1_000_000_000;
    private LocalDateTime date;

    public Gigasecond(LocalDate startDate) {
        date = addGigasecond(startDate.atStartOfDay());
    }

    public Gigasecond(LocalDateTime startTime) {
        date = addGigasecond(startTime);
    }

    private LocalDateTime addGigasecond(LocalDateTime localDateTime) {
        return localDateTime.plus(GIGASECOND, ChronoUnit.SECONDS);
    }


    public LocalDateTime getDateTime() {
        return date;
    }
}

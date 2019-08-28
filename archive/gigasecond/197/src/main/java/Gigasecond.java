import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private static final long GIGA_SECONDS = 1_000_000_000;
    private LocalDateTime localDateTime;

    Gigasecond(LocalDate moment) {
        this(moment.atStartOfDay());
    }

    Gigasecond(LocalDateTime moment) {
        localDateTime = moment;
    }

    LocalDateTime getDateTime() {
        return localDateTime.plusSeconds(GIGA_SECONDS);
    }
}
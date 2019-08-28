import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

class Gigasecond {

    private static final long gigasecond = 1_000_000_000;

    private final LocalDateTime dateTime;

    Gigasecond(LocalDate moment) {
        dateTime = LocalDateTime.of(moment, LocalTime.of(0, 0, 0));
    }

    Gigasecond(LocalDateTime moment) {
        dateTime = moment;
    }

    LocalDateTime getDateTime() {
        return dateTime.plusSeconds(gigasecond);
    }

}

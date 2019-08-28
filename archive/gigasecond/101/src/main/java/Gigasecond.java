
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAmount;

class Gigasecond {

    private static final long gigaSecond = (long) Math.pow(10, -9);
    private LocalDate date;
    private LocalDateTime dateTime;

    Gigasecond(LocalDate moment) {
        date = moment;
    }

    Gigasecond(LocalDateTime moment) {
        dateTime = moment;
    }

    LocalDateTime getDateTime() {
        LocalDateTime time = LocalDateTime.now();
        return time.plusSeconds(gigaSecond);

    }

}

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private final LocalDateTime newDateTime;
    final long SECONDS = (long) Math.pow(10, 9);

    Gigasecond(LocalDate moment) {
        this(moment.atStartOfDay());
    }

    Gigasecond(LocalDateTime moment) {
        newDateTime = moment.plus(Duration.ofSeconds(SECONDS));
    }

    LocalDateTime getDateTime() {
        return newDateTime;
    }

}

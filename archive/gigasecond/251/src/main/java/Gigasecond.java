import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Duration;

class Gigasecond {
    LocalDateTime newDateTime;
    final long SECONDS = (long) Math.pow(10, 9);

    Gigasecond(LocalDate moment) {
        newDateTime = moment.atStartOfDay().plus(Duration.ofSeconds(SECONDS));
    }

    Gigasecond(LocalDateTime moment) {
        newDateTime = moment.plus(Duration.ofSeconds(SECONDS));
    }

    LocalDateTime getDateTime() {
        return newDateTime;
    }

}

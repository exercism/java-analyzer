import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private LocalDateTime currentTime;

    Gigasecond(LocalDate moment) {
        currentTime = moment.atStartOfDay();
    }

    Gigasecond(LocalDateTime moment) {
        currentTime = moment;
    }

    LocalDateTime getDateTime() {
        return currentTime.plus(Duration.ofSeconds(1_000_000_000));
    }

}

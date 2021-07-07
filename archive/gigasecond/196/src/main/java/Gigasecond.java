import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Duration;

class Gigasecond {

    private final int seconds = 1_000_000_000;

    private LocalDateTime dateTime;

    Gigasecond(LocalDate moment) {
        this.dateTime = LocalDateTime.of(moment, LocalTime.MIN);
    }

    Gigasecond(LocalDateTime moment) {
        this.dateTime = moment;
    }

    LocalDateTime getDateTime() {
        return dateTime.plus(Duration.ofSeconds(seconds));
    }

}

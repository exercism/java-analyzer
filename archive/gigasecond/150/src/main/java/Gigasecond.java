import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

class Gigasecond {
    private LocalDateTime localDateTime;

    Gigasecond(LocalDate moment) {
        localDateTime = LocalDateTime.of(moment, LocalTime.MIN);
    }

    Gigasecond(LocalDateTime moment) {
        localDateTime = moment;
    }

    LocalDateTime getDateTime() {
        return localDateTime.plus(1_000_000_000, ChronoUnit.SECONDS);
    }

}

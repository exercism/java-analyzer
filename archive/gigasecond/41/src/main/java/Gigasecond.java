import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

class Gigasecond {
    private LocalDateTime dateTime;

    Gigasecond(LocalDate moment) {
        this.dateTime = moment.atStartOfDay();
    }

    Gigasecond(LocalDateTime moment) {
        this.dateTime = moment;
    }

    LocalDateTime getDateTime() {
        return dateTime.plus(1000000000, ChronoUnit.SECONDS);
    }

}

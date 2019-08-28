import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

class Gigasecond {

    private LocalDateTime moment;

    Gigasecond(LocalDate moment) {
        this(LocalDateTime.of(
                moment.getYear(), moment.getMonthValue(), moment.getDayOfMonth(),
                0, 0, 0)
        );
    }

    Gigasecond(LocalDateTime moment) {
        this.moment = moment;
    }

    LocalDateTime getDateTime() {
        return this.moment.plus(1000000000, ChronoUnit.SECONDS);
    }
}

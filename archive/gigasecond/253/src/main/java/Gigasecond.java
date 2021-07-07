import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

class Gigasecond {

    private final LocalDateTime MOMENT;
    private final int GIGASECOND = 1_000_000_000;

    Gigasecond(LocalDate moment) {
        this.MOMENT = moment.atTime(0, 0);
    }

    Gigasecond(LocalDateTime moment) {
        this.MOMENT = moment;
    }

    LocalDateTime getDateTime() {
        return this.MOMENT.plus(GIGASECOND, ChronoUnit.SECONDS);
    }

}

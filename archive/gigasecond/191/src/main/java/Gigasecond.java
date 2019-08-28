import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private static final long ONE_BILLION = 1_000_000_000;
    private final LocalDateTime moment;

    Gigasecond(LocalDate moment) {
        this.moment = moment.atStartOfDay();
    }

    Gigasecond(LocalDateTime moment) {
        this.moment = moment;
    }

    LocalDateTime getDateTime() {
        return moment.plusSeconds(ONE_BILLION);
    }

}

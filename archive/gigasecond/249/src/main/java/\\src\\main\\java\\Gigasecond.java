import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    private static final long gigaseconds = (long) 1e9;
    private final LocalDateTime moment;

    Gigasecond(LocalDate moment) {
        this.moment = moment.atStartOfDay();
    }

    Gigasecond(LocalDateTime moment) {
        this.moment = moment;
    }

    LocalDateTime getDateTime() {
        return this.moment.plusSeconds(gigaseconds);
    }

}

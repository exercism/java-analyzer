import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private final LocalDateTime datetime;

    Gigasecond(LocalDate moment) {
        this.datetime = moment.atStartOfDay();
    }

    Gigasecond(LocalDateTime moment) {
        this.datetime = moment;
    }

    LocalDateTime getDateTime() {
        return this.datetime.plusSeconds((long) 1e9);
    }
}

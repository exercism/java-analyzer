import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    private LocalDateTime datetime = null;

    Gigasecond(LocalDate moment) {
        this.datetime = moment.atStartOfDay();
    }

    Gigasecond(LocalDateTime moment) {
        this.datetime = moment;
    }

    LocalDateTime getDateTime() {
        return datetime.plusSeconds(1_000_000_000);
    }
}

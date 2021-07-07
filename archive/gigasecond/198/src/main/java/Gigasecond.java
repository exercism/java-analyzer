import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private LocalDateTime moment;

    Gigasecond(LocalDate moment) {
        this.moment = moment.atStartOfDay();
    }

    Gigasecond(LocalDateTime moment) {
        this.moment = moment;
    }

    LocalDateTime getDateTime() {
        return this.moment.plusSeconds(1_000_000_000);
    }

}

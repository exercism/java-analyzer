import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private final LocalDateTime momentInAGigasecond;

    Gigasecond(LocalDate moment) {
        this(moment.atStartOfDay());
    }

    Gigasecond(LocalDateTime moment) {
        this.momentInAGigasecond = moment.plusSeconds(1000000000);
    }

    LocalDateTime getDateTime() {
        return momentInAGigasecond;
    }

}

import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    LocalDateTime time;

    private static final long gigaSeconds = 1000000000;

    Gigasecond(LocalDate moment) {
        this.time = moment.atStartOfDay();
    }

    Gigasecond(LocalDateTime moment) {
        this.time = moment;
    }

    LocalDateTime getDateTime() {
        this.time = time.plusSeconds(gigaSeconds);
        return this.time;
    }

}

import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private long gigasecond = 1000000000L;
    private LocalDateTime moment;

    Gigasecond(LocalDate moment) {
        this(moment.atStartOfDay());
    }

    Gigasecond(LocalDateTime moment) {
        this.moment = moment.plusSeconds(gigasecond);
    }

    LocalDateTime getDateTime() {
        return this.moment;
    }

}

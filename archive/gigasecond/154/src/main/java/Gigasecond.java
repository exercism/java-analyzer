import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private LocalDateTime moment;

    private LocalDateTime gigaSecondsLater;

    private static final long SECONDS_DURATION = 1000000000L;

    Gigasecond(LocalDate moment) {
        this(moment.atStartOfDay());
    }

    Gigasecond(LocalDateTime moment) {
        this.moment = moment;
    }

    LocalDateTime getDateTime() {
        if(gigaSecondsLater == null) {
            gigaSecondsLater = moment.plusSeconds(SECONDS_DURATION);
        }
        return gigaSecondsLater;
    }

}

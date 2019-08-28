import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private final long GIGASECOND_IN_SECONDS = 1000000000;
    private final LocalDateTime moment;

    Gigasecond(LocalDate moment) {
        this.moment = moment.atStartOfDay();
    }

    Gigasecond(LocalDateTime moment) {
        this.moment = moment;
    }

    private LocalDateTime momentAfterAGigasecond(LocalDateTime moment) {
        return moment.plusSeconds(GIGASECOND_IN_SECONDS);
    }

    LocalDateTime getDateTime() {
        return momentAfterAGigasecond(moment);
    }

}

import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private static final Long GIGASECOND_IN_SECONDS = 1000000000L;

    private LocalDateTime moment;

    public Gigasecond(LocalDate moment) {
        this.moment = moment.atStartOfDay();
    }

    public Gigasecond(LocalDateTime moment) {
        this.moment = moment;
    }

    public LocalDateTime getDateTime() {
        return this.moment.plusSeconds(GIGASECOND_IN_SECONDS);
    }

}

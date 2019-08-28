import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

class Gigasecond {

    private final static int GIGASECOND = 1_000_000_000;

    private final LocalDateTime moment;

    Gigasecond(LocalDate moment) {
        Objects.requireNonNull(moment);
        this.moment = moment.atStartOfDay();
    }

    Gigasecond(LocalDateTime moment) {
        this.moment = moment;
    }

    LocalDateTime getDateTime() {
        return moment.plusSeconds(GIGASECOND);
    }

}

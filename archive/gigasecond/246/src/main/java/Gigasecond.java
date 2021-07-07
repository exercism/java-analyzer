import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    private final long gigaSecond = 1_000_000_000l;
    private final LocalDateTime gigaMoment;

    Gigasecond(LocalDate moment) {
        this(moment.atStartOfDay());
    }

    Gigasecond(LocalDateTime moment) {
        gigaMoment = moment.plusSeconds(gigaSecond);
    }

    LocalDateTime getDateTime() {
        return gigaMoment;
    }

}

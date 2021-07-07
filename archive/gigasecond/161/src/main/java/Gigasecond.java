import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

class Gigasecond {
    private static final long GIGASECOND = 1000000000L;

    private final LocalDateTime moment;

    Gigasecond(LocalDate moment) {
        this(Objects.requireNonNull(moment).atStartOfDay());
    }

    Gigasecond(LocalDateTime moment) {
        this.moment = Objects.requireNonNull(moment).plusSeconds(GIGASECOND);
    }

    LocalDateTime getDateTime() {
        return moment;
    }
}

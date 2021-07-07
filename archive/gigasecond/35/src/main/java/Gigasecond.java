import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

final class Gigasecond {

    private final static long GIGA_SECONDS = 1_000_000_000L;
    private final LocalDateTime localDateTime;

    Gigasecond(LocalDate moment) {
        this(moment.atStartOfDay());
    }

    Gigasecond(LocalDateTime moment) {
        Objects.requireNonNull(moment);
        this.localDateTime = moment.plusSeconds(GIGA_SECONDS);
    }

    LocalDateTime getDateTime() {
        return this.localDateTime;
    }

}

import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private static final long GIGASECONDS = 1_000_000_000;
    private LocalDateTime gigasecond;

    Gigasecond(LocalDate moment) {
        gigasecond = moment.atStartOfDay().plusSeconds(GIGASECONDS);
    }

    Gigasecond(LocalDateTime moment) {

        gigasecond = moment.plusSeconds(GIGASECONDS);
    }

    LocalDateTime getDateTime() {
        return gigasecond;
    }

}

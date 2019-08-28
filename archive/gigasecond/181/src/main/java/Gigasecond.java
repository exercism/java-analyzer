import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    private final int GIGASECOND = 1000000000;
    private LocalDateTime dateAndTimeAfterAGigaSecond;

    Gigasecond(final LocalDate moment) {
       this(moment.atStartOfDay());
    }

    Gigasecond(final LocalDateTime moment) {
        dateAndTimeAfterAGigaSecond = moment.plusSeconds(GIGASECOND);
    }

    LocalDateTime getDateTime() {
        return dateAndTimeAfterAGigaSecond;
    }

}

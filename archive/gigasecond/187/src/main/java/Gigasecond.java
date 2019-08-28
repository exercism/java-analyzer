import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private final static int SECONDS=1000000000;
    private LocalDateTime localDateTime;

    Gigasecond(LocalDate moment) {
        this.localDateTime=moment.atStartOfDay();

    }

    Gigasecond(LocalDateTime moment) {
        this.localDateTime=moment;

    }

    LocalDateTime getDateTime() {
        return localDateTime.plusSeconds(SECONDS);

    }

}

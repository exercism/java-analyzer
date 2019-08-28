import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private LocalDateTime future;
    private final static long toAdd = (long)Math.pow(10, 9);

    Gigasecond(LocalDate moment) {
        future = moment.atStartOfDay().plusSeconds(toAdd);
    }

    Gigasecond(LocalDateTime moment) {
        future = moment.plusSeconds(toAdd);
    }

    LocalDateTime getDateTime() {
        return future;
    }

}

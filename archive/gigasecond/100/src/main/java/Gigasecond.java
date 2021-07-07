import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    private final LocalDateTime dateTime;
    private static Long GIGASECOND = (long) Math.pow(10, 9);

    Gigasecond(LocalDate moment) {
        this.dateTime = moment.atStartOfDay().plusSeconds(GIGASECOND);
    }

    Gigasecond(LocalDateTime moment) {
        this.dateTime = moment.plusSeconds(GIGASECOND);
    }

    LocalDateTime getDateTime() {
        return this.dateTime;
    }

}

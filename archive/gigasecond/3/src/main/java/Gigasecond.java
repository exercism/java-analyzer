import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    LocalDateTime input;
    private static final long Gigasec = 1000000000;

    Gigasecond(LocalDate moment) {
        this(moment.atStartOfDay());
    }

    Gigasecond(LocalDateTime moment) {
        this.input = moment;

    }

    LocalDateTime getDateTime() {
        return input.plusSeconds(Gigasec);
    }

}

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

class Gigasecond {

    private static final Duration ONE_GIGASECOND = Duration.ofSeconds((long) Math.pow(10.0, 9.0));

    private LocalDateTime gigaDateTime;

    Gigasecond(LocalDate moment) {
        this(LocalDateTime.of(moment, LocalTime.MIDNIGHT));
    }

    Gigasecond(LocalDateTime moment) {
        this.gigaDateTime = moment.plus(ONE_GIGASECOND);
    }

    LocalDateTime getDateTime() {
        return gigaDateTime;
    }

}

import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    private LocalDateTime moment;

    private static final double GIGASSECOND_IN_SEC = Math.pow(10.0, 9.0);

    Gigasecond(LocalDate moment) {
        this.moment = moment.atTime(0, 0);
    }

    Gigasecond(LocalDateTime moment) {
        this.moment = moment;
    }

    LocalDateTime getDateTime() {
        return this.moment.plusSeconds( (long) GIGASSECOND_IN_SEC);
    }

}

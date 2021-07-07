import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

class Gigasecond {

    private final LocalDateTime gigaSecondLater;

    Gigasecond(LocalDate moment) {
        this.gigaSecondLater = moment.atTime(0, 0, 0).plus(Math.round(Math.pow(10, 9)), ChronoUnit.SECONDS);
    }

    Gigasecond(LocalDateTime moment) {
        this.gigaSecondLater = moment.plus(Math.round(Math.pow(10, 9)), ChronoUnit.SECONDS);
    }

    LocalDateTime getDateTime() {
        return this.gigaSecondLater;
    }

}

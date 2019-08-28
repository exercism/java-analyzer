import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

class Gigasecond {

    private LocalDateTime dateTime;
    private int gigasecond = 1000000000;

    Gigasecond(LocalDate moment) {
        this.dateTime = LocalDateTime.of(moment, LocalTime.MIN).plus(this.gigasecond, ChronoUnit.SECONDS);
    }

    Gigasecond(LocalDateTime moment) {
        this.dateTime = moment.plus(this.gigasecond, ChronoUnit.SECONDS);
    }

    LocalDateTime getDateTime() {
        return this.dateTime;
    }

}

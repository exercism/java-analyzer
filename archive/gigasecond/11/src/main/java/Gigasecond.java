import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

class Gigasecond {

    private  LocalDateTime moment;

    Gigasecond(LocalDate moment) {
        this.moment = LocalDateTime.of(moment, LocalTime.MIN);
    }

    Gigasecond(LocalDateTime moment) {
        this.moment = moment;
    }

    LocalDateTime getDateTime() {
        return moment.plus(1000_000_000, ChronoUnit.SECONDS);
    }

}

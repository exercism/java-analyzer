import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

class Gigasecond {

    private final LocalDateTime localDateTime;

    Gigasecond(LocalDate moment) {
        this.localDateTime = LocalDateTime.of(moment, LocalTime.MIN).plus(1000000000, ChronoUnit.SECONDS);

    }

    Gigasecond(LocalDateTime moment) {


        this.localDateTime = moment.plus(1000000000, ChronoUnit.SECONDS);

    }

    LocalDateTime getDateTime() {
        return this.localDateTime;
    }

}

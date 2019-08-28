import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

class Gigasecond {

    LocalDateTime moment;

    Gigasecond(LocalDate moment) {
        this(LocalDateTime.of(moment, LocalTime.MIDNIGHT));
    }

    Gigasecond(LocalDateTime moment) {
        this.moment = moment;
    }

    LocalDateTime getDateTime() {
        long gigasecond = 1_000_000_000;
        return moment.plusSeconds(gigasecond);
    }

}

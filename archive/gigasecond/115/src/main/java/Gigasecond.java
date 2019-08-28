import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

class Gigasecond {

    private static final long GIGA_SECOND = 1000000000;
    private LocalDateTime moment;

    Gigasecond(LocalDate moment) {
        this.moment = LocalDateTime.of(moment, LocalTime.MIDNIGHT).plusSeconds(GIGA_SECOND);
    }

    Gigasecond(LocalDateTime moment) {
        this.moment = moment.plusSeconds(GIGA_SECOND);
    }

    LocalDateTime getDateTime() {
        return moment;
    }

}

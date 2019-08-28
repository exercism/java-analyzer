import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

class Gigasecond {
    private static final int ONE_GIGASECOND = 1000000000;
    private LocalDateTime moment;

    Gigasecond(LocalDate moment) {
        this.moment = LocalDateTime.of(moment.getYear(), moment.getMonth()
                , moment.getDayOfMonth(), 0, 0);
    }

    Gigasecond(LocalDateTime moment) {
        this.moment = moment;
    }

    LocalDateTime getDateTime() {
        return moment.plusSeconds(ONE_GIGASECOND);
    }
}

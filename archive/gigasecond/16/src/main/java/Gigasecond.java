import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

class Gigasecond {
    static final int ONE_GIGASECOND = 1000000000;

    LocalDateTime moment;

    Gigasecond(LocalDate moment) {
       this.moment = moment.atStartOfDay();
    }

    Gigasecond(LocalDateTime moment) {
        this.moment = moment;
    }

    LocalDateTime getDateTime() {
        return moment.plusSeconds(ONE_GIGASECOND);
    }

}

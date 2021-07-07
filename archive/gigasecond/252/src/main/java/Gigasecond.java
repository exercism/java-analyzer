import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static java.time.LocalTime.MIDNIGHT;

class Gigasecond {

    private LocalDateTime moment;

    Gigasecond(LocalDate moment) {
        this(LocalDateTime.of(moment, MIDNIGHT));
    }

    Gigasecond(LocalDateTime moment) {
        this.moment = moment;
    }

    LocalDateTime getDateTime() {
        return moment.plusSeconds(1000000000);
    }

}

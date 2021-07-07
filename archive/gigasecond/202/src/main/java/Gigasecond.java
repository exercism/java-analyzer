import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    LocalDateTime time;

    Gigasecond(LocalDate moment) {
        this.time = moment.atTime(0, 0);
    }

    Gigasecond(LocalDateTime moment) {
        this.time = moment;
    }

    LocalDateTime getDateTime() {
        return this.time.plusSeconds(1000000000l);
    }

}

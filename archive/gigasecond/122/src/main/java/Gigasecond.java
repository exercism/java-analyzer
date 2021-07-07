import java.time.LocalDate;
import java.time.LocalDateTime;
import java.lang.Math;

class Gigasecond {
    LocalDateTime moment;

    Gigasecond(LocalDate moment) {
        this.moment = moment.atStartOfDay();
    }

    Gigasecond(LocalDateTime moment) {
        this.moment = moment;
    }

    LocalDateTime getDateTime() {
        return moment.plusSeconds((long) Math.pow(10, 9));
    }

}

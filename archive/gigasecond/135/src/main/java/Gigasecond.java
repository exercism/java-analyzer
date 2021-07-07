import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

class Gigasecond {

    LocalDateTime moment;

    Gigasecond(LocalDate moment) {
        this.moment = LocalDateTime.of(moment, LocalTime.MIN);
    }

    Gigasecond(LocalDateTime moment) {
        this.moment = moment;
    }

    LocalDateTime getDateTime() {
        return this.moment.plusSeconds((long) Math.pow(10, 9));
    }

}

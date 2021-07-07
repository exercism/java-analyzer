import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    LocalDateTime dateTime;

    Gigasecond(LocalDate moment) {
        dateTime = moment.atTime(0, 0, 0);
    }

    Gigasecond(LocalDateTime moment) {
        dateTime = moment;
    }

    LocalDateTime getDateTime() {
        return dateTime.plusSeconds(1000000000);
    }

}

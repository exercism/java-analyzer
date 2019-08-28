import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    LocalDateTime dateTime = null;

    Gigasecond(LocalDate moment) {
        dateTime = moment.atStartOfDay();
    }

    Gigasecond(LocalDateTime moment) {
        dateTime = moment;
    }

    LocalDateTime getDateTime() {
        return dateTime.plusSeconds(1_000_000_000);
    }

}

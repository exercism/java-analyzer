import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    LocalDateTime momentDateTime;

    Gigasecond(LocalDate moment) {
        momentDateTime = moment.atStartOfDay();
    }

    Gigasecond(LocalDateTime moment) {
        momentDateTime = moment;
    }

    LocalDateTime getDateTime() {
        LocalDateTime ldt = momentDateTime.plusSeconds(1000000000);
        return ldt;
    }

}

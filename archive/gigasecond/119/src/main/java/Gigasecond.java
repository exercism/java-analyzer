import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private LocalDateTime dateTime;

    Gigasecond(LocalDate moment) {
        this(moment.atStartOfDay());
    }

    Gigasecond(LocalDateTime moment) {
        dateTime = moment.plusSeconds(1000000000L);
    }

    LocalDateTime getDateTime() {
        return dateTime;
    }

}

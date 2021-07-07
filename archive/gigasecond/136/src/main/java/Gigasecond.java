import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private static final long GIGA_SECOND_INTERVAL = 1000000000;
    private LocalDateTime dateTime;

    Gigasecond(LocalDate moment) {
       dateTime = moment.atStartOfDay().plusSeconds(GIGA_SECOND_INTERVAL);
    }

    Gigasecond(LocalDateTime moment) {
       dateTime = moment.plusSeconds(GIGA_SECOND_INTERVAL);
    }

    LocalDateTime getDateTime() {
        return dateTime;
    }

}

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

class Gigasecond {

    private LocalDateTime gigasecondLater;

    Gigasecond(LocalDateTime moment) {
        gigasecondLater = moment.plus(1000000000, ChronoUnit.SECONDS);
    }

    Gigasecond(LocalDate moment) {
        this(moment.atTime(0, 0, 0));
    }
    
    LocalDateTime getDateTime() {
        return gigasecondLater;
    }

}

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

class Gigasecond {

    private LocalDateTime gigaSecondElapsedDateTime;

    Gigasecond(LocalDate moment) {
        this(moment.atStartOfDay());
    }

    Gigasecond(LocalDateTime moment) {
        gigaSecondElapsedDateTime = moment.plus((long) 10e8, ChronoUnit.SECONDS);
    }

    LocalDateTime getDateTime() {
        return gigaSecondElapsedDateTime;
    }

}

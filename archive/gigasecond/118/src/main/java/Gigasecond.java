import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

class Gigasecond {

	LocalDateTime resultDateTime;

    Gigasecond(LocalDate moment) {
        resultDateTime = LocalDateTime.of(moment, LocalTime.MIN).plus(1000000000, ChronoUnit.SECONDS);
    }

    Gigasecond(LocalDateTime moment) {
        resultDateTime = moment.plus(1000000000, ChronoUnit.SECONDS);
    }

    LocalDateTime getDateTime() {
        return resultDateTime;
    }

}

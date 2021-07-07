import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

class Gigasecond {
LocalDateTime first;

    Gigasecond(LocalDate moment) {
        first = LocalDateTime.of(moment, LocalTime.MIN);
    }

    Gigasecond(LocalDateTime moment) {
        first = moment;
    }

    LocalDateTime getDateTime() {
        return first.plusSeconds(1000000000);
    }

}

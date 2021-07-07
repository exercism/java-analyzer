import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

class Gigasecond {

    private LocalDateTime dateTime;

    Gigasecond(LocalDate moment) {
        dateTime = LocalDateTime.of(moment, LocalTime.MIDNIGHT);
    }

    Gigasecond(LocalDateTime moment) {
        dateTime = moment;
    }

    LocalDateTime getDateTime() {
        return dateTime.plusSeconds((long)Math.pow(10,9));
    }

}

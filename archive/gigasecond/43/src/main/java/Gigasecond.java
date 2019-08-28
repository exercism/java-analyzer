import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

class Gigasecond {
    private long epochSeconds;
    Gigasecond(LocalDate moment) {
        epochSeconds = moment.toEpochDay() * 24 * 60 * 60;
    }

    Gigasecond(LocalDateTime moment) {
        epochSeconds = moment.toEpochSecond(ZoneOffset.UTC);
    }

    LocalDateTime getDateTime() {
        return LocalDateTime.ofEpochSecond((long) (epochSeconds + Math.pow(10, 9)), 0, ZoneOffset.UTC);
    }

}

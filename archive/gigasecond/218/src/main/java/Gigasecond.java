import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    LocalDateTime lcd;

    Gigasecond(LocalDate moment) {
        lcd = moment.atStartOfDay();
    }

    Gigasecond(LocalDateTime moment) {
        lcd = moment;
    }

    LocalDateTime getDateTime() {
        return lcd.plusSeconds((long) (1 * Math.pow(10, 9)));
    }

}

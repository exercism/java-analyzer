import java.time.LocalDate;
import java.time.LocalDateTime;


class Gigasecond {
    LocalDateTime momentDateTime;


    Gigasecond(LocalDate moment) {
        this.momentDateTime = moment.atStartOfDay();
    }

    Gigasecond(LocalDateTime moment) {
        this.momentDateTime = moment;
    }

    LocalDateTime getDateTime() {
        return momentDateTime.plusSeconds((long)Math.pow(10, 9));
    }

}

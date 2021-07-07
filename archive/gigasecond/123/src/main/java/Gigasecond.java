import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    LocalDateTime localDate;

    Gigasecond(LocalDate moment) {
        this.localDate = moment.atStartOfDay();
    }

    Gigasecond(LocalDateTime moment) {
        this.localDate = moment;
    }

    LocalDateTime getDateTime() {
        return localDate.plus(Duration.ofSeconds(1000000000));
    }

}

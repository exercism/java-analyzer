import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

class Gigasecond {

    LocalDateTime localDateTime;

    Gigasecond(LocalDate moment) {
        this.localDateTime = moment.atTime(0,0).plusSeconds(1000000000);
    }

    Gigasecond(LocalDateTime moment) {
        this.localDateTime = moment.plusSeconds(1000000000);
    }

    LocalDateTime getDateTime() {
        return localDateTime;
    }

}

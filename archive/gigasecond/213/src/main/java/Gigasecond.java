import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    LocalDateTime time;
    Gigasecond(LocalDate moment) {
        time = moment.atStartOfDay().plusSeconds(1000000000);
    }
    Gigasecond(LocalDateTime moment) {
        time = moment.plusSeconds(1000000000);
    }
    LocalDateTime getDateTime() {
        return time;
    }
}

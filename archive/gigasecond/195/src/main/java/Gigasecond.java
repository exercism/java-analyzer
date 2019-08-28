import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    private LocalDateTime time;
    Gigasecond(LocalDate moment) {
        time = moment.atStartOfDay();
    }

    Gigasecond(LocalDateTime moment) {
        time = moment;
    }

    LocalDateTime getDateTime() {
        return time.plusSeconds(1000000000);
    }

}

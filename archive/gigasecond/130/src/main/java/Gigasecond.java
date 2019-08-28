import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    LocalDateTime t;
    Gigasecond(LocalDate moment) {
        this.t = moment.atTime(0,0,0);
    }
    Gigasecond(LocalDateTime moment) {
        this.t = moment;
    }
    LocalDateTime getDateTime() {
        return t.plusSeconds(1000000000);
    }
}

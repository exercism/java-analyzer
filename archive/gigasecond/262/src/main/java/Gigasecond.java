import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    private LocalDate d;
    private LocalDateTime dt;

    Gigasecond(LocalDate moment) {
        d = moment;
    }

    Gigasecond(LocalDateTime moment) {
        dt = moment;
    }

    LocalDateTime getDateTime() {
        if (d != null) {
            return d.atTime(0, 0).plusSeconds(1000000000);
        }
        else return dt.plusSeconds(1000000000);
    }

}

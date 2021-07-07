import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    private static final int GIGASECOND = 1000000000;
    private LocalDateTime dateTime;

    Gigasecond(LocalDate moment) {
        this.dateTime = LocalDateTime.from(moment.atTime(0,0,0)).plusSeconds(GIGASECOND);
    }

    Gigasecond(LocalDateTime moment) {
        this.dateTime = LocalDateTime.from(moment).plusSeconds(GIGASECOND);
    }

    LocalDateTime getDateTime() {
        return dateTime;
    }
}

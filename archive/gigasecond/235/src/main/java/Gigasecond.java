import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private LocalDateTime date;

    Gigasecond(LocalDate moment) {
        this.date = moment.atStartOfDay();
    }

    Gigasecond(LocalDateTime moment) {
        this.date = moment;
    }

    LocalDateTime getDateTime() {
        return this.date.plusSeconds((long) 1e9);
    }

}

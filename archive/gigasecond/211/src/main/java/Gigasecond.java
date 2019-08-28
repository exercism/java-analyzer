import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    private LocalDateTime dateTime;


    Gigasecond(LocalDate moment) {
        this.dateTime = moment.atStartOfDay();
    }

    Gigasecond(LocalDateTime moment) {
        this.dateTime = moment;
    }

    LocalDateTime getDateTime() {
        return this.dateTime.plusSeconds((long) Math.pow(10, 9));
    }

}

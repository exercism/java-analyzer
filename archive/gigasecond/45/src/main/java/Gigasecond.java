import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private LocalDateTime localDateTime;

    Gigasecond(LocalDate moment) {
        this.localDateTime = moment.atStartOfDay();
    }

    Gigasecond(LocalDateTime moment) {
        this.localDateTime = moment;
    }

    LocalDateTime getDateTime() {
       return this.localDateTime.plusSeconds((long) Math.pow(10, 9));
    }

}

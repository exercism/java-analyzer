import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private LocalDateTime localDateTime;

    Gigasecond(LocalDate moment) {
        this.localDateTime = moment.atTime(0, 0);
    }

    Gigasecond(LocalDateTime moment) {
        this.localDateTime = moment;
    }

    LocalDateTime getDateTime() {
        return localDateTime.plusSeconds(1000000000);
    }

}

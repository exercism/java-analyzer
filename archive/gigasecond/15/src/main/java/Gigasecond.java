import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

class Gigasecond {

    private LocalDateTime dateTime;

    Gigasecond(LocalDate moment) {
        this.dateTime = LocalDateTime.of(moment, LocalTime.of(0, 0)).plusSeconds(1000000000);
    }

    Gigasecond(LocalDateTime moment) {
        this.dateTime = moment.plusSeconds(1000000000);
    }

    LocalDateTime getDateTime() {
        return this.dateTime;
    }

}

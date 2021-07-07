import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private LocalDateTime moment;

    Gigasecond(LocalDate moment) {
        this.moment = moment.atTime(0, 0, 0).plusSeconds(1000000000);
    }

    Gigasecond(LocalDateTime moment) {
        this.moment = moment.plusSeconds(1000000000);
    }

    LocalDateTime getDateTime() {
        return this.moment;
    }

}

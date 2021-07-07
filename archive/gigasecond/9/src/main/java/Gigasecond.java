import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private LocalDateTime moment;

    Gigasecond(LocalDate moment) {
        this.moment = moment.atTime(0,0);
    }

    Gigasecond(LocalDateTime moment) {
        this.moment = moment;
    }

    LocalDateTime getDateTime() {
        int gigaSecond = 1000000000;
        return moment.plusSeconds(gigaSecond);
    }

}

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

class Gigasecond {
    private LocalDateTime moment;

    Gigasecond(LocalDate moment) {
        this.moment = LocalDateTime.of(moment.getYear(), moment.getMonth(), moment.getDayOfMonth(), 0, 0, 0);
    }

    Gigasecond(LocalDateTime moment) {
        this.moment = moment;
    }

    LocalDateTime getDateTime() {

        return this.moment.plusSeconds(1000000000);
    }

}

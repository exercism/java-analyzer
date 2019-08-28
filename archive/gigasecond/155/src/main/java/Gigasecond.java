import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAmount;

class Gigasecond {

    private LocalDateTime moment;

    Gigasecond(LocalDate moment) {
        this.moment = LocalDateTime.from(moment.atStartOfDay());
    }

    Gigasecond(LocalDateTime moment) {
        this.moment = moment;
    }

    LocalDateTime getDateTime() {
        return moment.plusSeconds((long) Math.pow(10, 9));
    }

}

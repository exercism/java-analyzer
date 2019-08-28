import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

class Gigasecond {
    LocalDateTime moment;
    Gigasecond(LocalDate moment) {
        this.moment = LocalDateTime.of(moment,LocalTime.of(0,0,0));
    }

    Gigasecond(LocalDateTime moment) {
        this.moment = moment;
    }

    LocalDateTime getDateTime() {
        return moment.plusSeconds(1000000000);
    }

}

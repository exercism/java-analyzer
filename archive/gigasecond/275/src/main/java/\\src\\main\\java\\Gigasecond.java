import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

class Gigasecond {
    LocalDateTime moment;
    
    Gigasecond(LocalDate moment) {
        this.moment = moment.atTime( LocalTime.of(0, 0, 0) );
    }

    Gigasecond(LocalDateTime moment) {
        this.moment = moment;
    }

    LocalDateTime getDateTime() {
        return this.moment.plusSeconds(1000000000);
    }

}

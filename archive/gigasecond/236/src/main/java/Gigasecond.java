import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    private final long GIGASECOND = 1000000000;
    private LocalDateTime moment;
    
    Gigasecond(LocalDate moment) {
        this.moment = moment.atStartOfDay();
    }

    Gigasecond(LocalDateTime moment) {
        this.moment = moment;
    }

    LocalDateTime getDateTime() {
        return this.moment.plusSeconds(this.GIGASECOND);
    }

}

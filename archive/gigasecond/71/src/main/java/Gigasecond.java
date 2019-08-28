import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    LocalDateTime now;
    long GIGASECONDS = 1000000000L;

    Gigasecond(LocalDate moment) {
        this.now = moment.atStartOfDay();
    }

    Gigasecond(LocalDateTime moment) {
        this.now = moment;
    }

    LocalDateTime getDateTime() {
        return now.plusSeconds(GIGASECONDS);
    }

}

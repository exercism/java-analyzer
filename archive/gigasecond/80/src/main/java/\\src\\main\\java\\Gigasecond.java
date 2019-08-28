import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    LocalDateTime start;

    Gigasecond(LocalDate moment) {
        this.start = moment.atStartOfDay();
    }

    Gigasecond(LocalDateTime moment) {
        this.start = moment;
    }

    LocalDateTime getDateTime() {
      return this.start.plusSeconds(1000000000);
    }

}
